package auction

/**
 * Created by Kenji on 4/3/2015.
 */
import geb.spock.GebSpec
import grails.plugin.remotecontrol.RemoteControl
import auction.pages.AccountPage
import auction.pages.LoginPage
import spock.lang.Stepwise

@Stepwise
class ReviewFunctionalSpec extends GebSpec {

    def remote = new AuctionRemoteControl()

    def setup() {
        remote {
            ['ROLE_ADMIN', 'ROLE_USER'].each {
                if (!Role.findByAuthority(it)) {
                    new Role(authority: it).save(flush: true, failOnError: true)
                }
            }
            def user1 = new User(username: 'testadmin', password: 'admin1234').save(failOnError: true, flush: true)
            def  user2 = new User(username: 'testuser', password: 'user1234').save(failOnError: true, flush: true)

            Address add1 = new Address(addressName:"Home",address1: '5342 Northport Dr', city: 'Brooklyn Center', state: 'MN', zip: '55429').save(failOnError: true, flush: true)
            Address add2= new Address(addressName:"Wayne Manor",address1: '1000 Wayne Manor Dr', city: 'Gotham City', state: 'NY', zip: '54353').save(failOnError: true, flush: true)

            Account acc1 = new Account(user: user1, name: 'Kenji Vue',  email: 'kenjivue@live.com', address: add1).save(failOnError: true, flush: true)
            Account acc2 = new Account(user: user2,name: 'Bruce Wayne',  email: 'batman@gotham.com',address: add2).save(failOnError: true, flush: true)
            new UserRole(user:user1,role:Role.findByAuthority('ROLE_ADMIN')).save(failOnError: true, flush: true)
            new UserRole(user:user2,role:Role.findByAuthority('ROLE_USER')).save(failOnError: true, flush: true)

            Listing list1=new Listing(listingName: 'Batmobile',listingDescription:'Used Batmobile , heavily damaged from crimefighting:  This is a fixer-upper, recommended for enthusiasts',
                    listingDays: 20, startDate: new Date().minus(25),startingPrice: 50000,owner: acc2,deliveredby: 'US Only',endDate: new Date().plus(20)).save(failOnError: true, flush: true)
            Listing list2=new Listing(listingName: 'Umbrella',listingDescription:'Umbrella used to stab the mayor in the heart',
                    listingDays: 20, startDate: new Date().minus(9),startingPrice: 1000,owner: acc3,deliveredby: 'Worldwide', endDate: new Date().plus(20)).save(failOnError: true, flush: true)
            Bid b1 = new Bid(amount: 50000.75, bidder:acc1, listing: list1, bidDate: new Date().minus(19)).save(failOnError: true, flush: true)
            Bid b2 = new Bid(amount: 50100.00, bidder:acc2, listing: list1, bidDate: new Date().minus(18)).save(failOnError: true, flush: true)
            Bid b3 = new Bid(amount: 50200.75, bidder:acc1, listing: list1, bidDate: new Date().minus(16)).save(failOnError: true, flush: true)
            Bid b4 = new Bid(amount: 50300.75, bidder:acc2, listing: list1, bidDate: new Date().minus(15)).save(failOnError: true, flush: true)
            Bid b5 = new Bid(amount: 50400.75, bidder:acc1, listing: list1, bidDate: new Date().minus(14)).save(failOnError: true, flush: true)
            new Review(reviewer: acc1, reviewType: 'Seller', account: acc2, listing: list1, comments: 'Horrible Customer Service - Kept wanting to eat fish', thumbsUp: false).save(failOnError: true, flush: true)
            new Review(reviewer: acc2, reviewType: 'Seller', account: acc1, listing: list2,comments: 'Awesome', thumbsUp: true).save(failOnError: true, flush: true)

        }
    }

    void cleanup() {
        remote {
            def user1=  User.findByUsername('testadmin')
            def user2= User.findByUsername('testuser')
            Account.findByUser(user1).delete()
            Account.findByName(user2).delete()
            UserRole.findByUser(user1).delete()
            UserRole.findByUser(user2).delete()
        }
    }

    def "get User details"() {
        when:
        to AccountPage, id: acc1

        then:
        name.text() == acc1.name
        id.text() == acc1.id
        email.text()==acc1.email

    }
    def "Update user data"(){

    }
}
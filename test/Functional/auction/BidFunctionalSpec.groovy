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
class BidFunctionalSpec extends GebSpec {

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

    def "Test Bid"() {
    }
    def "Update user data"(){

    }
}
package auction

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(BidController)
@Mock([Account,Address,Listing,Bid,Delivery])
class BidControllerSpec extends Specification {
def setup(){
    def add1 = new Address(addressName:"Home",address1: '5342 Northport Dr', city: 'Brooklyn Center', state: 'MN', zip: '55429').save(failOnError: true, flush: true)
    def   add2= new Address(addressName:"Wayne Manor",address1: '1000 Wayne Manor Dr', city: 'Gotham City', state: 'NY', zip: '54353').save(failOnError: true, flush: true)
    def    acc1 = new Account(name: 'Kenji Vue', password: 'sdfjks7898', email: 'kenjivue@live.com', address: add1).save(failOnError: true, flush: true)
    def   acc2 = new Account(name: 'Bruce Wayne', password: 'Batman589', email: 'batman@gotham.com',address: add2).save(failOnError: true, flush: true)
    def    del1= new Delivery(delivery: 'US Only').save(failOnError: true, flush: true)
    def   del2= new Delivery(delivery: 'Worldwide').save(failOnError: true, flush: true)
    def   list1=new Listing(listingName: 'Batmobile',
                listingDescription:'Used Batmobile , heavily damaged from crimefighting:  This is a fixer-upper, recommended for enthusiasts',
                listingDays: 20, startDate: new Date().minus(25),startingPrice: 50000,
                owner: acc1,deliveredby: del1,endDate: new Date().plus(20)).save(failOnError: true, flush: true)
    def   list2=new Listing(listingName: 'Umbrella',
                listingDescription:'Umbrella used to stab the mayor in the heart',
                listingDays: 20, startDate: new Date().minus(9),startingPrice: 1000,
                owner: acc1,deliveredby: del2, endDate: new Date().plus(20)).save(failOnError: true, flush: true)
}


    def cleanup() {
    }

    void "Test Bid creation"() {
        setup:
        Bid b1 = new Bid(amount: 50000.75, bidder:acc1, listing: list1, bidDate: new Date().minus(19))
        when: "Bid Save"
         b1.save(failOnError: true, flush: true)
        then: "bid Successfully saved"
        response.redirectedUrl == '/Bid/show/1'
        controller.flash.message != null
        Bid.count() == 1

    }
    void "Test Bidding"() {
        setup:
        Bid b1 = new Bid(amount: 50000.75, bidder:acc2, listing: list1, bidDate: new Date().minus(19))
        Bid b2 = new Bid(amount: 50000.00, bidder:acc2, listing: list1, bidDate: new Date().minus(18)).save(failOnError: true, flush: true)
        when: "Bid Save"
        b1.save(failOnError: true, flush: true)
        b2.save(failOnError: true, flush: true)
        then: "Error:  Following bid must be greater than the first"
        response.status="404"


    }
    void "Bidder cannot bid on his own listing"() {
        setup:
        Bid b1 = new Bid(amount: 50000.75, bidder:acc1, listing: list1, bidDate: new Date().minus(19))
        when: "Bid Save"
        b1.save(failOnError: true, flush: true)
        b2.save(failOnError: true, flush: true)
        then: "Error:  Following bid must be greater than the first"
        response.status="404"


    }
}

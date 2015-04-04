package auction

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

@TestFor(BidController)
@Mock([Account,Address,Listing,Bid])
class BidControllerSpec extends Specification {
    def setup(){

    }


    def cleanup() {
    }

    void "Test Bid creation"() {
        setup:
        Address add1 = new Address(addressName:"Home",address1: '5342 Northport Dr', city: 'Brooklyn Center', state: 'MN', zip: '55429').save(failOnError: true, flush: true)
        Address add2= new Address(addressName:"Wayne Manor",address1: '1000 Wayne Manor Dr', city: 'Gotham City', state: 'NY', zip: '54353').save(failOnError: true, flush: true)
        Address add3 = new Address(addressName:"Arkham Asylum",address1: '220 Arkham Rd', city: 'Gotham City', state: 'NY', zip: '54353').save(failOnError: true, flush: true)
        Address add4= new Address(addressName:"Watch Tower",address1: '1212 Watchtower st', city: 'Gotham City', state: 'NY', zip: '54353').save(failOnError: true, flush: true)
        Address add5= new Address(addressName:"City Hall",address1: '1212 Main St', city: 'Gotham City', state: 'NY', zip: '54353').save(failOnError: true, flush: true)

        Account acc1 = new Account(name: 'Kenji Vue', password: 'sdfjks7898', email: 'kenjivue@live.com', address: add1).save(failOnError: true, flush: true)
        Account acc2 = new Account(name: 'Bruce Wayne', password: 'Batman589', email: 'batman@gotham.com',address: add2).save(failOnError: true, flush: true)
        Account acc3 = new Account(name: 'Oswald CobblePot', password: 'penguin666', email: 'peguin@evil.com',address: add3).save(failOnError: true, flush: true)
        Account acc4= new Account(name: 'Jim Gordon', password: 'C0mi55ioner', email: 'commish@gotham.com',address: add5).save(failOnError: true, flush: true)
        Account acc5= new Account(name: 'Edward Nigma', password: 'R1dddlemeThis', email: 'Riddler@evil.com',address: add3).save(failOnError: true, flush: true)
        Account acc6 = new Account(name: 'Fish Mooney', password: 'GanstaB1t**', email: 'gaasta@evil.com',address: add3).save(failOnError: true, flush: true)
        Account acc7 = new Account(name: 'Barbara Gordon', password: 'Batgirl65', email: 'batgirl@batfamily.com',address: add4).save(failOnError: true, flush: true)
        Account acc8= new Account(name: 'Dick Grayson', password: 'NightWing95', email: 'robin@batfamily.com',address: add4).save(failOnError: true, flush: true)
        def   list1=new Listing(listingName: 'Batmobile',
                listingDescription:'Used Batmobile , heavily damaged from crimefighting:  This is a fixer-upper, recommended for enthusiasts',
                listingDays: 20, startDate: new Date().minus(25),startingPrice: 50000,
                owner: acc1,deliveredby: "US Only",endDate: new Date().plus(20)).save(failOnError: true, flush: true)
        def   list2=new Listing(listingName: 'Umbrella',
                listingDescription:'Umbrella used to stab the mayor in the heart',
                listingDays: 20, startDate: new Date().minus(9),startingPrice: 1000,
                owner: acc1,deliveredby: "US Only", endDate: new Date().plus(20)).save(failOnError: true, flush: true)
        Bid b1 = new Bid(amount: 50000.75, bidder: acc1, listing: list1, bidDate: new Date().minus(19))
        when: "Bid Save"
        b1.save(failOnError: true, flush: true)
        then: "bid Successfully saved"
        response.redirectedUrl == '/Bid/show/1'
        controller.flash.message != null
        Bid.count() == 1

    }
    void "Test Bidding"() {
        setup:
        Address add1 = new Address(addressName:"Home",address1: '5342 Northport Dr', city: 'Brooklyn Center', state: 'MN', zip: '55429').save(failOnError: true, flush: true)
        Address add2= new Address(addressName:"Wayne Manor",address1: '1000 Wayne Manor Dr', city: 'Gotham City', state: 'NY', zip: '54353').save(failOnError: true, flush: true)
        Address add3 = new Address(addressName:"Arkham Asylum",address1: '220 Arkham Rd', city: 'Gotham City', state: 'NY', zip: '54353').save(failOnError: true, flush: true)
        Address add4= new Address(addressName:"Watch Tower",address1: '1212 Watchtower st', city: 'Gotham City', state: 'NY', zip: '54353').save(failOnError: true, flush: true)
        Address add5= new Address(addressName:"City Hall",address1: '1212 Main St', city: 'Gotham City', state: 'NY', zip: '54353').save(failOnError: true, flush: true)

        Account acc1 = new Account(name: 'Kenji Vue', password: 'sdfjks7898', email: 'kenjivue@live.com', address: add1).save(failOnError: true, flush: true)
        Account acc2 = new Account(name: 'Bruce Wayne', password: 'Batman589', email: 'batman@gotham.com',address: add2).save(failOnError: true, flush: true)
        Account acc3 = new Account(name: 'Oswald CobblePot', password: 'penguin666', email: 'peguin@evil.com',address: add3).save(failOnError: true, flush: true)
        Account acc4= new Account(name: 'Jim Gordon', password: 'C0mi55ioner', email: 'commish@gotham.com',address: add5).save(failOnError: true, flush: true)
        Account acc5= new Account(name: 'Edward Nigma', password: 'R1dddlemeThis', email: 'Riddler@evil.com',address: add3).save(failOnError: true, flush: true)
        Account acc6 = new Account(name: 'Fish Mooney', password: 'GanstaB1t**', email: 'gaasta@evil.com',address: add3).save(failOnError: true, flush: true)
        Account acc7 = new Account(name: 'Barbara Gordon', password: 'Batgirl65', email: 'batgirl@batfamily.com',address: add4).save(failOnError: true, flush: true)
        Account acc8= new Account(name: 'Dick Grayson', password: 'NightWing95', email: 'robin@batfamily.com',address: add4).save(failOnError: true, flush: true)


        def   list1=new Listing(listingName: 'Batmobile',
                listingDescription:'Used Batmobile , heavily damaged from crimefighting:  This is a fixer-upper, recommended for enthusiasts',
                listingDays: 20, startDate: new Date().minus(25),startingPrice: 50000,
                owner: acc1,deliveredby: "US Only",endDate: new Date().plus(20)).save(failOnError: true, flush: true)
        def   list2=new Listing(listingName: 'Umbrella',
                listingDescription:'Umbrella used to stab the mayor in the heart',
                listingDays: 20, startDate: new Date().minus(9),startingPrice: 1000,
                owner: acc1,deliveredby: "Worldwide", endDate: new Date().plus(20)).save(failOnError: true, flush: true)
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
        Address add1 = new Address(addressName:"Home",address1: '5342 Northport Dr', city: 'Brooklyn Center', state: 'MN', zip: '55429').save(failOnError: true, flush: true)
        Address add2= new Address(addressName:"Wayne Manor",address1: '1000 Wayne Manor Dr', city: 'Gotham City', state: 'NY', zip: '54353').save(failOnError: true, flush: true)
        Address add3 = new Address(addressName:"Arkham Asylum",address1: '220 Arkham Rd', city: 'Gotham City', state: 'NY', zip: '54353').save(failOnError: true, flush: true)
        Address add4= new Address(addressName:"Watch Tower",address1: '1212 Watchtower st', city: 'Gotham City', state: 'NY', zip: '54353').save(failOnError: true, flush: true)
        Address add5= new Address(addressName:"City Hall",address1: '1212 Main St', city: 'Gotham City', state: 'NY', zip: '54353').save(failOnError: true, flush: true)

        Account acc1 = new Account(name: 'Kenji Vue', password: 'sdfjks7898', email: 'kenjivue@live.com', address: add1).save(failOnError: true, flush: true)
        Account acc2 = new Account(name: 'Bruce Wayne', password: 'Batman589', email: 'batman@gotham.com',address: add2).save(failOnError: true, flush: true)
        Account acc3 = new Account(name: 'Oswald CobblePot', password: 'penguin666', email: 'peguin@evil.com',address: add3).save(failOnError: true, flush: true)
        Account acc4= new Account(name: 'Jim Gordon', password: 'C0mi55ioner', email: 'commish@gotham.com',address: add5).save(failOnError: true, flush: true)
        Account acc5= new Account(name: 'Edward Nigma', password: 'R1dddlemeThis', email: 'Riddler@evil.com',address: add3).save(failOnError: true, flush: true)
        Account acc6 = new Account(name: 'Fish Mooney', password: 'GanstaB1t**', email: 'gaasta@evil.com',address: add3).save(failOnError: true, flush: true)
        Account acc7 = new Account(name: 'Barbara Gordon', password: 'Batgirl65', email: 'batgirl@batfamily.com',address: add4).save(failOnError: true, flush: true)
        Account acc8= new Account(name: 'Dick Grayson', password: 'NightWing95', email: 'robin@batfamily.com',address: add4).save(failOnError: true, flush: true)

          def   list1=new Listing(listingName: 'Batmobile',
                listingDescription:'Used Batmobile , heavily damaged from crimefighting:  This is a fixer-upper, recommended for enthusiasts',
                listingDays: 20, startDate: new Date().minus(25),startingPrice: 50000,
                owner: acc1,deliveredby: "US Only",endDate: new Date().plus(20)).save(failOnError: true, flush: true)
        def   list2=new Listing(listingName: 'Umbrella',
                listingDescription:'Umbrella used to stab the mayor in the heart',
                listingDays: 20, startDate: new Date().minus(9),startingPrice: 1000,
                owner: acc1,deliveredby: "Worldwide", endDate: new Date().plus(20)).save(failOnError: true, flush: true)
        Bid b1 = new Bid(amount: 50000.75, bidder:acc1, listing: list1, bidDate: new Date().minus(19))
        Bid b2 = new Bid(amount: 51000, bidder:acc1, listing: list1, bidDate: new Date().minus(16))
        when: "Bid Save"
        b1.save(failOnError: true, flush: true)
        b2.save(failOnError: true, flush: true)
        then: "Error:  Bidder cannot bid on his own listing"
        response.status="404"

    }
}

package auction

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

@TestMixin(GrailsUnitTestMixin)
@Mock([Account,Address])

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(ListingController)
@Mock([Account,Address,Listing])
class ListingControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test List controller inputs"() {
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


        Listing list1=new Listing(listingName: 'Batmobile',listingDescription:'Used Batmobile , heavily damaged from crimefighting:  This is a fixer-upper, recommended for enthusiasts',
                listingDays: 20, startDate: new Date().minus(25),startingPrice: 50000,owner: acc2,deliveredby: "Worldwide",endDate: new Date().plus(20)).save(failOnError: true, flush: true)
        when:
        list1.setStartDate(sdate)
        list1.setDeliveredby(deliveredby)
        list1.setListingDays(listdays)
        list1.setListingName(lname)
        list1.setListingDescription(ldescription)
        list1.setOwner(owner)
        list1.setStartingPrice(sprice)
        println('Validation ='+list1.validate())
        then:
        list1.validate()==listvalidation
        where:
        lname                       | ldescription              |listdays           |sdate              |sprice         |owner      |deliveredby           |listvalidation
        'Valid Listing'             | 'Test listing Desc'       |120                | new Date()        |100.00         |acc1       |"Worldwide"           |true
        'No Description'            |null                       |50                 | new Date()        |100.00         |acc1       |"Worldwide"           |true
        'No days'                   | 'Test listing Desc'       |null               | new Date()        |100.00         |acc1       |"Worldwide"           |false
        'No StartDate'              | 'Test listing Desc'       |120                | null              |100.00         |acc1       |"Worldwide"           |false
        'No Start amount'           | 'Test listing Desc'       |120                | new Date()        |null           |acc1       |"Worldwide"           |false
        'No Owner'                  | 'Test listing Desc'       |120                | new Date()        |100.00         |null       |"Worldwide"           |false
        'No Delivery'               | 'Test listing Desc'       |120                | new Date()        |100.00         |acc1       |null                  |false
        'Start amount is Zero'      | 'Test listing Desc'       |120                | new Date()        |0              |acc1       |"Worldwide"           |false
        'StartDate is not a date '  | 'Test listing Desc'       |120                |'sdfsdsf'          |100            |acc1       |"Worldwide"           |false
        'listing days is not valid' | 123123    |'sfds'         |100                |new Date()         |-100           |acc1       |"Worldwide"           |false
        'Account is not valid'      | 'Test listing Desc'       |120                | new Date()        |100            |'Joe'      |"Worldwide"           |false
        'Start amount is negative'  | 'Test listing Desc'       |120                | new Date()        |-5000          |acc1       |"Worldwide"           |false

    }
}

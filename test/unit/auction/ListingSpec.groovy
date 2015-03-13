package auction

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class ListingSpec extends Specification {

    def setup() {
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

        Delivery del1= new Delivery(delivery: 'US Only').save(failOnError: true, flush: true)
        Delivery del2= new Delivery(delivery: 'Worldwide').save(failOnError: true, flush: true)
        Delivery del3= new Delivery(delivery: 'Pick Up Only').save(failOnError: true, flush: true)

    }

    def cleanup() {
    }

    void "test something"() {
    }
}

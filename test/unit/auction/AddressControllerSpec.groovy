package auction

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(AddressController)
@Mock(Address)
class AddressControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Verify Address "() {
        setup:
        Address addresstest = new Address(addressName:"Home",address1: '5342 Northport Dr', city: 'Brooklyn Center', state: 'MN', zip: '55429').save(failOnError: true, flush: true)
        when:
        addresstest.setAddress1(add1)
        addresstest.setAddress2(add2)
        addresstest.setAddressName(addName)
        addresstest.setCity(city)
        addresstest.setState(state)
        addresstest.setZip(zip)
        println('Validation ='+addresstest.validate())
        then:
        addresstest.validate()==addressvalidation
        where:
        add1                | add2              |addName            |city           |zip        |state  |addressvalidation
        '123 jones   st'    | null              |'Home '            |'Cleveland'    |'55429'    |'MN'   |true
        '123 jones   st'    | null              |null               |'Cleveland'    |'55429'    |'MN'   |true
        null                | null              |'Home '            |'Cleveland'    |'55429'    |'MN'   |false
        '123 jones   st'    | '123 jones   st'  |'Home '            |'Cleveland'    |'55429'    |'MN'   |true
        '123 jones   st'    | null              |'Home '            |null           |'55429'    |'MN'   |false
        '123 jones   st'    | null              |'Home '            |'Cleveland'    |'55429'    |null   |false
        '123 jones   st'    | ''                |'Home '            |'Cleveland'    |'55429'    |'MN'   |true
        '123 jones   st'    | null              |''                 |'Cleveland'    |'55429'    |'MN'   |true
        ''                  | ''                |'Home '            |'Cleveland'    |'55429'    |'MN'   |false
        '123 jones   st'    | '123 jones   st'  |'Home '            |'Cleveland'    |'55429'    |'MN'   |true
        '123 jones   st'    | ''                |'Home '            |''             |'55429'    |'MN'   |false
        '123 jones   st'    | ''                |'Home '            |'Cleveland'    |'55429'    |null   |false

    }
}

package auction

import grails.test.mixin.Mock
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@Mock([Account,Address])
class AccountControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Verify Password"() {
        setup:
        Address add1 = new Address(addressName:"Home",address1: '5342 Northport Dr', city: 'Brooklyn Center', state: 'MN', zip: '55429').save(failOnError: true, flush: true)
        def tacc = new Account(name: 'Kenji Vue', password: 'sdfjks7898', email: 'kenjivue@live.com', address: add1);
        when:
        tacc.setPassword(tpass)
        println('password:' +tacc.getPassword()+' Validation ='+tacc.validate())
        then:
        tacc.validate()==validation
        where:
        tpass           | validation
        '         '     | false
        'sdajflajfd'    | false
        '2389432423'    | false
        'dhjfd dfss'    | false
        '&^*****&**'    | false
        ''              | false
        'Hello12345'    | true



    }
    void "Verify email"() {
        setup:
        Address add2 = new Address(addressName:"Home",address1: '5342 Northport Dr', city: 'Brooklyn Center', state: 'MN', zip: '55429').save(failOnError: true, flush: true)
        def tacc2 = new Account(name: 'Kenji Vue', password: 'sdfjks7898', email: 'kenjivue@live.com', address: add2);
        when:
        tacc2.setEmail(temail)
        println('email:' +tacc2.getEmail()+' Validation ='+tacc2.validate())
        then:
        tacc2.validate()==emailvalidation
        where:
        temail              | emailvalidation
        '         '         | true
        'djksfddfdd'        | false
        '2389432423'        | false
        'dhjfd dfss'        | false
        ''                  | true
        'Hello12345'        | false
        'dsffsdl.co'        | false
        'joe@live.com'      | true
        'jake@do.org'       | true



    }
    void "Verify Address Addition"() {
        setup:
        Address add3 = new Address(addressName:"Home",address1: '5342 Northport Dr', city: 'Brooklyn Center', state: 'MN', zip: '55429').save(failOnError: true, flush: true)
        def tacc3 = new Account(name: 'Kenji Vue', password: 'sdfjks7898', email: 'kenjivue@live.com', address: add3);
        when:
        tacc3.setAddress(address)
        println('Validation ='+tacc3.validate())
        then:
        tacc3.validate()==addressvalidation
        where:
        address              | addressvalidation
        null                | false
    }

}

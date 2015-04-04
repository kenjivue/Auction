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
class AccountFunctionalSpec extends GebSpec {

    def remote = new AuctionRemoteControl()

    def accountid

    def setupSpec() {
        to LoginPage
        login('kenjivue', 'sdfjks7898')
    }

    void setup() {
        accountid = remote {
            def account = new Account(name: "Kenji Vue")
            account.save()
            account.id
        }
    }

    void cleanup() {
        remote {
            Account.findByName('Kenji Vue').delete()
        }
    }

    def "gets artist details"() {
        when:
        to AccountPage, id: accountid

        then:
        name.text() == 'Kenji Vue'
        accountid.text() == "Id: ${id}"

    }
}
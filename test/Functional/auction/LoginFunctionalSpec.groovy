package auction

import auction.pages.ListingPage

/**
 * Created by Kenji on 4/3/2015.
 */

import geb.spock.GebSpec
import grails.plugin.remotecontrol.RemoteControl
import auction.pages.AccountPage
import auction.pages.LoginPage
import spock.lang.Stepwise

@Stepwise
class LoginFunctionalSpec extends GebSpec {
    def remote = new AuctionRemoteControl()

    def "invalid login"() {
        given: "I am at the login page"
        to LoginPage

        when: "I am entering invalid password"
        loginForm.j_username = "me@gmail.com"
        loginForm.j_password = "ioguffwf"
        loginButton.click()

        then: "I am being redirected to the login page"
        at LoginPage
        !loginForm.j_username
        !loginForm.j_password
    }

    def "admin login"() {
        given : "I am at the login page"
        to LoginPage

        when: "I am entering valid username and password"
        loginForm.j_username = "me@gmail.com"
        loginForm.j_password = "me"
        loginButton.click()

        then: "I am being redirected to the homepage"
        at ListingPage
    }
}
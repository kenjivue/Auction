package auction.pages

/**
 * Created by Kenji on 4/3/2015.
 */
import geb.Page


class LoginPage extends Page {

    static url = "login/auth"

    static at = { title == "Login" }

    static content = {
        loginForm { $("#loginForm") }
        loginButton { $("#loginButton") }
        registerLink { $("a[href*='register/index']") }
    }
}
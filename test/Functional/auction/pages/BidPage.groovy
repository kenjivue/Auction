package auction.pages

import geb.Page

/**
 * Created by Kenji on 4/3/2015.
 */
class BidPage extends Page {

    static url = 'login/auth'

    static content = {
        username { $("#username") }
        password { $("#password ") }
        submit { $("#submit") }
    }
}
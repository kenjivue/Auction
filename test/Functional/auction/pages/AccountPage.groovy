package auction.pages

/**
 * Created by Kenji on 4/3/2015.
 */
import geb.Page

class AccountPage extends Page {

    static url = 'account/get/${id}'

    static at = {
        title == 'Account Detail Page'
    }

    static content = {
        id {$('#id')}
        email { $('#email') }
        name { $('#name') }
        address { $('#address') }
        saveBtn { $('#save-btn') }
    }
}
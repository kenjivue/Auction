package auction.pages

/**
 * Created by Kenji on 4/3/2015.
 */
import geb.Page

class AddressPage extends Page {

    static url = 'address/get/${id}'

    static at = {
        title == 'Address'
    }

    static content = {
        addressName { $('#addressName') }
        address1 { $('#address1') }
        address2 { $('#address2') }
        city { $('#city') }
        state { $('#state') }
        zipcode { $('#zipcode') }
        created { $('#datecreated') }
        saveBtn { $('#save-btn') }
    }
}
package auction.pages

import geb.Page

/**
 * Created by Kenji on 4/3/2015.
 */
class ListingPage extends Page {

    static url = 'Listing/get/${id}'

    static at = {
        title == 'Listings'
    }

    static content = {
        name { $('#listingName') }
        description { $('#listingDescription') }
        listingDays { $('#listingDays') }
        startingPrice { $('#startingPrice') }
        startDate { $('#startDate') }
        owner { $('#owner') }
        endDate { $('#endDate') }
        saveBtn { $('#save-btn') }
    }
}
package auction.pages

import geb.Page

/**
 * Created by Kenji on 4/3/2015.
 */
class BidPage extends Page {

    static url = 'bid/get/${id}'

    static at = {
        title == 'Bids'
    }

    static content = {
        listing { $('#Listing') }
        bidder { $('#bidder') }
        amount { $('#amoudatent') }
        bidDate { $('#bid') }
    }
}
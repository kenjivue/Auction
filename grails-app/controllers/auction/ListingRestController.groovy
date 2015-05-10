package auction

import grails.rest.RestfulController

class ListingRestController extends RestfulController<Listing> {
    @SuppressWarnings("GroovyUnusedDeclaration")
    static responseFormats = ['json', 'xml']

    ListingRestController(){
        super(Listing)
    }
    def index(Integer max, String q) {
        if (!q) {
            return super.index(max)
        }
        params.max = Math.min(max ?: 10, 100)

        def listings = Listing.where { listingName =~ "%${q.toLowerCase()}%" }.list(max: max)
        respond listings, model: [listingCount: listings.size()]
    }
}

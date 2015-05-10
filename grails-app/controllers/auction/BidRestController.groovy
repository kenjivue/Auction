package auction

import grails.rest.RestfulController

class BidRestController extends RestfulController<Bid>{

    @SuppressWarnings("GroovyUnusedDeclaration")
    static responseFormats = ['json', 'xml']

    BidRestController() {
        super(Bid)
    }
    def index(Integer max, String q) {
        if (!q) {
            return super.index(max)
        }
        params.max = Math.min(max ?: 10, 100)

        def bids = Bid.list(max: max)
        respond bids, model: [reviewCount: bids.size()]
    }
}
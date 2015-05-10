package auction

import grails.rest.RestfulController

class ReviewRestController extends RestfulController<Review>{

    @SuppressWarnings("GroovyUnusedDeclaration")
    static responseFormats = ['json', 'xml']

    ReviewRestController() {
        super(Review)
    }
    def index(Integer max, String q) {
        if (!q) {
            return super.index(max)
        }
        params.max = Math.min(max ?: 10, 100)

        def reviews = Review.where { comments =~ "%${q.toLowerCase()}%" }.list(max: max)
        respond reviews, model: [reviewCount: reviews.size()]
    }
}
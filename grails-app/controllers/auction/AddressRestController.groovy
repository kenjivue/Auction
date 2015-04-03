package auction
import grails.rest.RestfulController
class AddressRestController extends RestfulController<Address> {
    @SuppressWarnings("GroovyUnusedDeclaration")
    static responseFormats = ['json', 'xml']

    AddressRestController() {
        super(Address)
    }

    def index(Integer max, String q) {
        if (!q) {
            return super.index(max)
        }
        params.max = Math.min(max ?: 10, 100)

        def addresses = Address.where { addressName =~ "%${q.toLowerCase()}%" }.list(max: max)
        respond addresses, model: [accountCount: addresses.size()]
    }
}

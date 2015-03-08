package auction



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BidController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Bid.list(params), model:[bidInstanceCount: Bid.count()]
    }
    def list(){
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [bidList: Bid.list(params), bidTotal: Bid.count()]
    }
    def show(Bid bidInstance) {
        respond bidInstance
    }

    def create() {
        def list=Listing.findById(params.id)
        if(!list){
            response.sendError(404)
        }else{
            def bid=new Bid(listing:list)
            respond bid
        }
    }
    @Transactional
    def save(Bid bidInstance) {
        if (bidInstance == null) {
            notFound()
            return
        }

        if (bidInstance.hasErrors()) {
            respond bidInstance.errors, view:'create'
            return
        }

        bidInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bid.label', default: 'Bid'), bidInstance.id])
                redirect (controller: "listing",action:"history",id:bidInstance.listing.id)
            }
            '*' { respond bidInstance, [status: CREATED] }
        }
    }

    def edit(Bid bidInstance) {
        respond bidInstance
    }

    @Transactional
    def update(Bid bidInstance) {
        if (bidInstance == null) {
            notFound()
            return
        }

        if (bidInstance.hasErrors()) {
            respond bidInstance.errors, view:'edit'
            return
        }

        bidInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Bid.label', default: 'Bid'), bidInstance.id])
                redirect bidInstance
            }
            '*'{ respond bidInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Bid bidInstance) {

        if (bidInstance == null) {
            notFound()
            return
        }

        bidInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Bid.label', default: 'Bid'), bidInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bid.label', default: 'Bid'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

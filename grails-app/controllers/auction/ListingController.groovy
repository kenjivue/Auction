package auction


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import auction.Bid
@Transactional(readOnly = true)
class ListingController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Listing.list(params), model: [listingInstanceCount: Listing.count()]
    }

    def show(Listing listingInstance) {
        respond listingInstance
    }
    def getBids(params) {
        Listing listingInstance = params.listingInstance
        Bid bidList = Bid.findByListing(listingInstance)
        if (!bidList) {
            response.sendError(404)
        } else {

        respond bidList.getAmount().max()
    }
}
    def createNewBid(){
        def listing = Listing.get(params.id)
        if(!listing){
            redirect(controller: "bidding",action: "create")
        }else{
            redirect(controller: "bidding",action: "create",id:listing.id)
        }
    }
    def create() {
        respond new Listing(params)
    }

    @Transactional
    def save(Listing listingInstance) {
        if (listingInstance == null) {
            notFound()
            return
        }

        if (listingInstance.hasErrors()) {
            respond listingInstance.errors, view: 'create'
            return
        }

        listingInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'listing.label', default: 'Listing'), listingInstance.id])
                redirect listingInstance
            }
            '*' { respond listingInstance, [status: CREATED] }
        }
    }

    def edit(Listing listingInstance) {
        respond listingInstance
    }

    @Transactional
    def update(Listing listingInstance) {
        if (listingInstance == null) {
            notFound()
            return
        }

        if (listingInstance.hasErrors()) {
            respond listingInstance.errors, view: 'edit'
            return
        }

        listingInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Listing.label', default: 'Listing'), listingInstance.id])
                redirect listingInstance
            }
            '*' { respond listingInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Listing listingInstance) {

        if (listingInstance == null) {
            notFound()
            return
        }

        listingInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Listing.label', default: 'Listing'), listingInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'listing.label', default: 'Listing'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}

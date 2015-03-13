package auction

import org.h2.api.DatabaseEventListener
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import groovy.time.TimeCategory
import auction.Bid
@Transactional(readOnly = true)
class ListingController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def Bids(Listing listingInstance){
        return listingInstance.bids.count()
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def today = new Date()
        def current = Listing.where{ endDate >= today}
        respond current.list(params), model: [listingInstanceCount: current.count()]
    }
    def find(String filter, boolean completed, Integer max){
        params.max=Math.min(max?:10,100)
        def today=new Date()

        if(completed){
            def completedListings = Listing.where{(listingName ==~ "%${params.filter}%"|| listingDescription  ==~ "%${params.filter}%") && endDate < today }
            respond completedListings.list(params), model: [listingInstanceCount: completedListings.size()],view :'index'
        }else{
            def completedListings = Listing.where{(listingName ==~ "%${params.filter}%"|| listingDescription  ==~ "%${params.filter}%") && endDate >= today }
            respond completedListings.list(params), model: [listingInstanceCount: completedListings.size()],view :'index'
        }

    }
    def show(Listing listingInstance) {
        respond listingInstance
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
        listingInstance.endDate=listingInstance.startDate.plus(listingInstance.listingDays)
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
        if (listingInstance.endDate==null){
            listingInstance.endDate=listingInstance.startDate.plus(listingInstance.listingDays)
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

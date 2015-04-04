package auction

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*

class BidController {
    static responseFormats = ['json']
    def springSecurityService
    static allowedMethods = [create: "POST", update: "PUT", delete: "DELETE", get:"GET"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Bid.list(params), model:[bidInstanceCount: Bid.count()]
    }
    def get(){
        Long bidid = params.id
        Bid bidList =Bid.findById(bidid)
    if (!bidList){
        response.sendError(404)
    }
        Bid currentbid = bidList.where{
            amount==max(amount)
        }
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [bidList:bidlist, bidTotal: Bid.count(), bidcurrent:currentbid.amount ]
    }
    def show(Bid bidInstance) {
        respond bidInstance
    }
    @Secured("ROLE_USER")
    def create() {
        Account account=Account.findByUser(springSecurityService.currentUser as User)
        def listing=Listing.findById(params.id)
        Bid bidList =Bid.findByListing(listing)
        Bid currentbid = bidList.where{
            amount==max(amount)
        }
        if(!listing || currentbid.amount<params.amount-0.5 || listing.owner == account){
            response.sendError(404)
        }else{
            def bid=new Bid(Listing:listing, amount: params.amount, bidder:account )
            respond bid
        }
    }
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

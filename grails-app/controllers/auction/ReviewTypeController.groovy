package auction


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ReviewTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ReviewType.list(params), model: [reviewTypeInstanceCount: ReviewType.count()]
    }

    def show(ReviewType reviewTypeInstance) {
        respond reviewTypeInstance
    }

    def create() {
        respond new ReviewType(params)
    }

    @Transactional
    def save(ReviewType reviewTypeInstance) {
        if (reviewTypeInstance == null) {
            notFound()
            return
        }

        if (reviewTypeInstance.hasErrors()) {
            respond reviewTypeInstance.errors, view: 'create'
            return
        }

        reviewTypeInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'reviewType.label', default: 'ReviewType'), reviewTypeInstance.id])
                redirect reviewTypeInstance
            }
            '*' { respond reviewTypeInstance, [status: CREATED] }
        }
    }

    def edit(ReviewType reviewTypeInstance) {
        respond reviewTypeInstance
    }

    @Transactional
    def update(ReviewType reviewTypeInstance) {
        if (reviewTypeInstance == null) {
            notFound()
            return
        }

        if (reviewTypeInstance.hasErrors()) {
            respond reviewTypeInstance.errors, view: 'edit'
            return
        }

        reviewTypeInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ReviewType.label', default: 'ReviewType'), reviewTypeInstance.id])
                redirect reviewTypeInstance
            }
            '*' { respond reviewTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ReviewType reviewTypeInstance) {

        if (reviewTypeInstance == null) {
            notFound()
            return
        }

        reviewTypeInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ReviewType.label', default: 'ReviewType'), reviewTypeInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'reviewType.label', default: 'ReviewType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}

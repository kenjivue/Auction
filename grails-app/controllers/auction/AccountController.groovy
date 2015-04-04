package auction

import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
class AccountController {
    static responseFormats = ['json']
    def springSecurityService
    def accountService
    static allowedMethods = [create: "POST", update: "PUT", delete: "DELETE", get:"GET"]
    @Secured("ROLE_ADMIN")
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Account.list(params), model:[accountInstanceCount: Account.count()]
    }
    @Secured(closure = {
        def username = request.requestURI.substring(request.requestURI.lastIndexOf('/')+1)
        authentication.principal.username == username
    })
    def get() {
        [account: Account.findByUser(springSecurityService.currentUser)]
    }

    @Secured(closure = {
        def username = request.requestURI.substring(request.requestURI.lastIndexOf('/')+1)
        authentication.principal.username == username
    }, httpMethod = 'POST')
    def update() {
        def account = accountService.updateAccount(params.id, params)
        if (account.hasErrors()) {
            flash.error = 'Error saving'
            flash.errors = account.errors.allErrors
        } else {
            flash.info = 'Account saved'
        }
        redirect(action: 'get', id: account.user.username)
    }


}

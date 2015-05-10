package auction

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
class AccountController {
    static responseFormats = ['json']
    def springSecurityService
    def accountService
    static allowedMethods = [create: "POST", update: "PUT", delete: "DELETE", get:"GET"]
    def index() {
        if (!params.max || params.max > 25) {
            params.max = 25
        }
        JSON.use('deep')
        respond Account.list(max: params.max , offset:params.offset ) as JSON
    }
    @Secured(closure = {
        def username = request.requestURI.substring(request.requestURI.lastIndexOf('/')+1)
        authentication.principal.username == username
    })
    def get() {
        [account: Account.findByUser(springSecurityService.currentUser as User)]
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

package auction

import grails.plugin.springsecurity.annotation.Secured

class AccountController {
    static allowedMethods = [update: "PUT", show: "GET", delete: "DELETE"]
    static responseFormats = ['json']

    def springSecurityService
    def accountService
    @Secured(closure = {
        def username = request.requestURI.substring(request.requestURI.lastIndexOf('/')+1)
        authentication.principal.username == username
    }, httpMethod = 'GET')
    def get() {
        [account: Account.findByUser(springSecurityService.currentUser as User)]
    }

    @Secured(closure = {
        def username = request.requestURI.substring(request.requestURI.lastIndexOf('/')+1)
        authentication.principal.username == username
    }, httpMethod = 'PUT')
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

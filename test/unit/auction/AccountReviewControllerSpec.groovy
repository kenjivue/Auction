package auction


import grails.test.mixin.*
import spock.lang.*

@TestFor(AccountReviewController)
@Mock(AccountReview)
class AccountReviewControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when: "The index action is executed"
        controller.index()

        then: "The model is correct"
        !model.accountReviewInstanceList
        model.accountReviewInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when: "The create action is executed"
        controller.create()

        then: "The model is correctly created"
        model.accountReviewInstance != null
    }

    void "Test the save action correctly persists an instance"() {

        when: "The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        def accountReview = new AccountReview()
        accountReview.validate()
        controller.save(accountReview)

        then: "The create view is rendered again with the correct model"
        model.accountReviewInstance != null
        view == 'create'

        when: "The save action is executed with a valid instance"
        response.reset()
        populateValidParams(params)
        accountReview = new AccountReview(params)

        controller.save(accountReview)

        then: "A redirect is issued to the show action"
        response.redirectedUrl == '/accountReview/show/1'
        controller.flash.message != null
        AccountReview.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when: "The show action is executed with a null domain"
        controller.show(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the show action"
        populateValidParams(params)
        def accountReview = new AccountReview(params)
        controller.show(accountReview)

        then: "A model is populated containing the domain instance"
        model.accountReviewInstance == accountReview
    }

    void "Test that the edit action returns the correct model"() {
        when: "The edit action is executed with a null domain"
        controller.edit(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the edit action"
        populateValidParams(params)
        def accountReview = new AccountReview(params)
        controller.edit(accountReview)

        then: "A model is populated containing the domain instance"
        model.accountReviewInstance == accountReview
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when: "Update is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(null)

        then: "A 404 error is returned"
        response.redirectedUrl == '/accountReview/index'
        flash.message != null


        when: "An invalid domain instance is passed to the update action"
        response.reset()
        def accountReview = new AccountReview()
        accountReview.validate()
        controller.update(accountReview)

        then: "The edit view is rendered again with the invalid instance"
        view == 'edit'
        model.accountReviewInstance == accountReview

        when: "A valid domain instance is passed to the update action"
        response.reset()
        populateValidParams(params)
        accountReview = new AccountReview(params).save(flush: true)
        controller.update(accountReview)

        then: "A redirect is issues to the show action"
        response.redirectedUrl == "/accountReview/show/$accountReview.id"
        flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when: "The delete action is called for a null instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(null)

        then: "A 404 is returned"
        response.redirectedUrl == '/accountReview/index'
        flash.message != null

        when: "A domain instance is created"
        response.reset()
        populateValidParams(params)
        def accountReview = new AccountReview(params).save(flush: true)

        then: "It exists"
        AccountReview.count() == 1

        when: "The domain instance is passed to the delete action"
        controller.delete(accountReview)

        then: "The instance is deleted"
        AccountReview.count() == 0
        response.redirectedUrl == '/accountReview/index'
        flash.message != null
    }
}

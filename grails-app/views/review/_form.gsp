<%@ page import="auction.Review" %>



<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'reviewType', 'error')} required">
	<label for="reviewType">
		<g:message code="review.reviewType.label" default="Review Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="reviewType" name="reviewType.id" from="${auction.ReviewType.list()}" optionKey="id" required="" value="${reviewInstance?.reviewType?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'account', 'error')} required">
	<label for="account">
		<g:message code="review.account.label" default="Account" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="account" name="account.id" from="${auction.Account.list()}" optionKey="id" required="" value="${reviewInstance?.account?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'reviewer', 'error')} required">
	<label for="reviewer">
		<g:message code="review.reviewer.label" default="Reviewer" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="reviewer" name="reviewer.id" from="${auction.Account.list()}" optionKey="id" required="" value="${reviewInstance?.reviewer?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'comments', 'error')} required">
	<label for="comments">
		<g:message code="review.comments.label" default="Comments" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="comments" required="" value="${reviewInstance?.comments}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'datecreated', 'error')} required">
	<label for="datecreated">
		<g:message code="review.datecreated.label" default="Datecreated" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="datecreated" precision="day"  value="${reviewInstance?.datecreated}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'thumbsUp', 'error')} ">
	<label for="thumbsUp">
		<g:message code="review.thumbsUp.label" default="Thumbs Up" />
		
	</label>
	<g:checkBox name="thumbsUp" value="${reviewInstance?.thumbsUp}" />

</div>


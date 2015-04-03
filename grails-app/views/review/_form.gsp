<%@ page import="auction.Review" %>



<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'reviewType', 'error')} required">
	<label for="reviewType">
		<g:message code="review.reviewType.label" default="Review Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="reviewType" from="${reviewInstance.constraints.reviewType.inList}" required="" value="${reviewInstance?.reviewType}" valueMessagePrefix="review.reviewType"/>

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

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'comments', 'error')} ">
	<label for="comments">
		<g:message code="review.comments.label" default="Comments" />
		
	</label>
	<g:textField name="comments" value="${reviewInstance?.comments}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'thumbsUp', 'error')} ">
	<label for="thumbsUp">
		<g:message code="review.thumbsUp.label" default="Thumbs Up" />
		
	</label>
	<g:checkBox name="thumbsUp" value="${reviewInstance?.thumbsUp}" />

</div>


<%@ page import="auction.Review" %>



<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'reviewtype', 'error')} required">
	<label for="reviewtype">
		<g:message code="review.reviewtype.label" default="Reviewtype" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="reviewtype" required="" value="${reviewInstance?.reviewtype}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'comments', 'error')} required">
	<label for="comments">
		<g:message code="review.comments.label" default="Comments" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="comments" required="" value="${reviewInstance?.comments}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'reviewee', 'error')} required">
	<label for="reviewee">
		<g:message code="review.reviewee.label" default="Reviewee" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="reviewee" name="reviewee.id" from="${auction.AccountReview.list()}" optionKey="id" required="" value="${reviewInstance?.reviewee?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'reviewer', 'error')} required">
	<label for="reviewer">
		<g:message code="review.reviewer.label" default="Reviewer" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="reviewer" name="reviewer.id" from="${auction.Account.list()}" optionKey="id" required="" value="${reviewInstance?.reviewer?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'thumbsUp', 'error')} ">
	<label for="thumbsUp">
		<g:message code="review.thumbsUp.label" default="Thumbs Up" />
		
	</label>
	<g:checkBox name="thumbsUp" value="${reviewInstance?.thumbsUp}" />

</div>


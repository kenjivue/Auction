<%@ page import="auction.Account" %>



<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="account.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${accountInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="account.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="150" required="" value="${accountInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'address', 'error')} required">
	<label for="address">
		<g:message code="account.address.label" default="Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="address" from="${auction.Address.list()}" multiple="multiple" optionKey="id" size="5" required="" value="${accountInstance?.address*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'dateUpdated', 'error')} required">
	<label for="dateUpdated">
		<g:message code="account.dateUpdated.label" default="Date Updated" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateUpdated" precision="day"  value="${accountInstance?.dateUpdated}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'reviews', 'error')} ">
	<label for="reviews">
		<g:message code="account.reviews.label" default="Reviews" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${accountInstance?.reviews?}" var="r">
    <li><g:link controller="review" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="review" action="create" params="['account.id': accountInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'review.label', default: 'Review')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="account.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${auction.User.list()}" optionKey="id" required="" value="${accountInstance?.user?.id}" class="many-to-one"/>

</div>


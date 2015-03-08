<%@ page import="auction.Listing" %>



<div class="fieldcontain ${hasErrors(bean: listingInstance, field: 'owner', 'error')} required">
	<label for="owner">
		<g:message code="listing.owner.label" default="Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="owner" name="owner.id" from="${auction.Account.list()}" optionKey="id" required="" value="${listingInstance?.owner?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: listingInstance, field: 'listingName', 'error')} required">
	<label for="listingName">
		<g:message code="listing.listingName.label" default="Listing Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="listingName" required="" value="${listingInstance?.listingName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: listingInstance, field: 'listingDays', 'error')} required">
	<label for="listingDays">
		<g:message code="listing.listingDays.label" default="Listing Days" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="listingDays" type="number" value="${listingInstance.listingDays}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: listingInstance, field: 'startingPrice', 'error')} required">
	<label for="startingPrice">
		<g:message code="listing.startingPrice.label" default="Starting Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="startingPrice" value="${fieldValue(bean: listingInstance, field: 'startingPrice')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: listingInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="listing.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="day"  value="${listingInstance?.startDate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: listingInstance, field: 'deliveredby', 'error')} required">
	<label for="deliveredby">
		<g:message code="listing.deliveredby.label" default="Deliveredby" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="deliveredby" name="deliveredby.id" from="${auction.Delivery.list()}" optionKey="id" required="" value="${listingInstance?.deliveredby?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: listingInstance, field: 'listingDescription', 'error')} required">
	<label for="listingDescription">
		<g:message code="listing.listingDescription.label" default="Listing Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="listingDescription" required="" value="${listingInstance?.listingDescription}"/>

</div>


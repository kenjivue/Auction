<%@ page import="auction.Bid" %>



<div class="fieldcontain ${hasErrors(bean: bidInstance, field: 'bidder', 'error')} required">
	<label for="bidder">
		<g:message code="bid.bidder.label" default="Bidder" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="bidder" name="bidder.id" from="${auction.Account.list()}" optionKey="id" required="" value="${bidInstance?.bidder?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: bidInstance, field: 'amount', 'error')} required">
	<label for="amount">
		<g:message code="bid.amount.label" default="Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="amount" value="${fieldValue(bean: bidInstance, field: 'amount')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: bidInstance, field: 'bidDate', 'error')} required">
	<label for="bidDate">
		<g:message code="bid.bidDate.label" default="Bid Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="bidDate" precision="day"  value="${bidInstance?.bidDate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: bidInstance, field: 'listing', 'error')} required">
	<label for="listing">
		<g:message code="bid.listing.label" default="Listing" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="listing" name="listing.id" from="${auction.Listing.list()}" optionKey="id" required="" value="${bidInstance?.listing?.id}" class="many-to-one"/>

</div>





<%@ page import="auction.Bid" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bid.label', default: 'Bid')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-bid" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-bid" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list bid">
			
				<g:if test="${bidInstance?.bidder}">
				<li class="fieldcontain">
					<span id="bidder-label" class="property-label"><g:message code="bid.bidder.label" default="Bidder" /></span>
					
						<span class="property-value" aria-labelledby="bidder-label"><g:link controller="account" action="show" id="${bidInstance?.bidder?.id}">${bidInstance?.bidder?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${bidInstance?.amount}">
				<li class="fieldcontain">
					<span id="amount-label" class="property-label"><g:message code="bid.amount.label" default="Amount" /></span>
					
						<span class="property-value" aria-labelledby="amount-label"><g:fieldValue bean="${bidInstance}" field="amount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bidInstance?.bidDate}">
				<li class="fieldcontain">
					<span id="bidDate-label" class="property-label"><g:message code="bid.bidDate.label" default="Bid Date" /></span>
					
						<span class="property-value" aria-labelledby="bidDate-label"><g:formatDate date="${bidInstance?.bidDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${bidInstance?.listing}">
				<li class="fieldcontain">
					<span id="listing-label" class="property-label"><g:message code="bid.listing.label" default="Listing" /></span>
					
						<span class="property-value" aria-labelledby="listing-label"><g:link controller="listing" action="show" id="${bidInstance?.listing?.id}">${bidInstance?.listing?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			

			
			</ol>
			<g:form url="[resource:bidInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${bidInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

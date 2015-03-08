
<%@ page import="auction.Listing" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'listing.label', default: 'Listing')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-listing" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-listing" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list listing">
			
				<g:if test="${listingInstance?.owner}">
				<li class="fieldcontain">
					<span id="owner-label" class="property-label"><g:message code="listing.owner.label" default="Owner" /></span>
					
						<span class="property-value" aria-labelledby="owner-label"><g:link controller="account" action="show" id="${listingInstance?.owner?.id}">${listingInstance?.owner?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${listingInstance?.listingName}">
				<li class="fieldcontain">
					<span id="listingName-label" class="property-label"><g:message code="listing.listingName.label" default="Listing Name" /></span>
					
						<span class="property-value" aria-labelledby="listingName-label"><g:fieldValue bean="${listingInstance}" field="listingName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${listingInstance?.listingDays}">
				<li class="fieldcontain">
					<span id="listingDays-label" class="property-label"><g:message code="listing.listingDays.label" default="Listing Days" /></span>
					
						<span class="property-value" aria-labelledby="listingDays-label"><g:fieldValue bean="${listingInstance}" field="listingDays"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${listingInstance?.startingPrice}">
				<li class="fieldcontain">
					<span id="startingPrice-label" class="property-label"><g:message code="listing.startingPrice.label" default="Starting Price" /></span>
					
						<span class="property-value" aria-labelledby="startingPrice-label"><g:fieldValue bean="${listingInstance}" field="startingPrice"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${listingInstance?.startDate}">
				<li class="fieldcontain">
					<span id="startDate-label" class="property-label"><g:message code="listing.startDate.label" default="Start Date" /></span>
					
						<span class="property-value" aria-labelledby="startDate-label"><g:formatDate date="${listingInstance?.startDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${listingInstance?.deliveredby}">
				<li class="fieldcontain">
					<span id="deliveredby-label" class="property-label"><g:message code="listing.deliveredby.label" default="Deliveredby" /></span>
					
						<span class="property-value" aria-labelledby="deliveredby-label"><g:link controller="delivery" action="show" id="${listingInstance?.deliveredby?.id}">${listingInstance?.deliveredby?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${listingInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="listing.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${listingInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${listingInstance?.listingDescription}">
				<li class="fieldcontain">
					<span id="listingDescription-label" class="property-label"><g:message code="listing.listingDescription.label" default="Listing Description" /></span>
					
						<span class="property-value" aria-labelledby="listingDescription-label"><g:fieldValue bean="${listingInstance}" field="listingDescription"/></span>
					
				</li>
				</g:if>
			
			</ol>

			<g:form url="[resource:listingInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${listingInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

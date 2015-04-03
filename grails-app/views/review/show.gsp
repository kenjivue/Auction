
<%@ page import="auction.Review" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'review.label', default: 'Review')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-review" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-review" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list review">
			
				<g:if test="${reviewInstance?.reviewType}">
				<li class="fieldcontain">
					<span id="reviewType-label" class="property-label"><g:message code="review.reviewType.label" default="Review Type" /></span>
					
						<span class="property-value" aria-labelledby="reviewType-label"><g:fieldValue bean="${reviewInstance}" field="reviewType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reviewInstance?.account}">
				<li class="fieldcontain">
					<span id="account-label" class="property-label"><g:message code="review.account.label" default="Account" /></span>
					
						<span class="property-value" aria-labelledby="account-label"><g:link controller="account" action="show" id="${reviewInstance?.account?.id}">${reviewInstance?.account?.name}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${reviewInstance?.reviewer}">
				<li class="fieldcontain">
					<span id="reviewer-label" class="property-label"><g:message code="review.reviewer.label" default="Reviewer" /></span>
					
						<span class="property-value" aria-labelledby="reviewer-label"><g:link controller="account" action="show" id="${reviewInstance?.reviewer?.id}">${reviewInstance?.reviewer?.name}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${reviewInstance?.comments}">
				<li class="fieldcontain">
					<span id="comments-label" class="property-label"><g:message code="review.comments.label" default="Comments" /></span>
					
						<span class="property-value" aria-labelledby="comments-label"><g:fieldValue bean="${reviewInstance}" field="comments"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reviewInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="review.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${reviewInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${reviewInstance?.thumbsUp}">
				<li class="fieldcontain">
					<span id="thumbsUp-label" class="property-label"><g:message code="review.thumbsUp.label" default="Thumbs Up" /></span>
					
						<span class="property-value" aria-labelledby="thumbsUp-label"><g:formatBoolean boolean="${reviewInstance?.thumbsUp}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:reviewInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${reviewInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

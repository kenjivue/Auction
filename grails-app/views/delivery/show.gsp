
<%@ page import="auction.Delivery" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'delivery.label', default: 'Delivery')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-delivery" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-delivery" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list delivery">
			
				<g:if test="${deliveryInstance?.delivery}">
				<li class="fieldcontain">
					<span id="delivery-label" class="property-label"><g:message code="delivery.delivery.label" default="Delivery" /></span>
					
						<span class="property-value" aria-labelledby="delivery-label"><g:fieldValue bean="${deliveryInstance}" field="delivery"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${deliveryInstance?.datecreated}">
				<li class="fieldcontain">
					<span id="datecreated-label" class="property-label"><g:message code="delivery.datecreated.label" default="Datecreated" /></span>
					
						<span class="property-value" aria-labelledby="datecreated-label"><g:formatDate date="${deliveryInstance?.datecreated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:deliveryInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${deliveryInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

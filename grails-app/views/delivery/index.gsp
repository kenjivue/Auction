
<%@ page import="auction.Delivery" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'delivery.label', default: 'Delivery')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-delivery" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-delivery" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="delivery" title="${message(code: 'delivery.delivery.label', default: 'Delivery')}" />
					
						<g:sortableColumn property="datecreated" title="${message(code: 'delivery.datecreated.label', default: 'Datecreated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${deliveryInstanceList}" status="i" var="deliveryInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${deliveryInstance.id}">${fieldValue(bean: deliveryInstance, field: "delivery")}</g:link></td>
					
						<td><g:formatDate date="${deliveryInstance.datecreated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${deliveryInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>

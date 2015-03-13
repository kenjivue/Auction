
<%@ page import="auction.ReviewType; auction.Account" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'account.label', default: 'Account')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-account" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-account" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<tr><th>Account Details</th><th>Reviews</th></tr>
				<tr><td>
			<ol class="property-list account">
			
				<g:if test="${accountInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="account.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${accountInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="account.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${accountInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="account.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${accountInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="account.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${accountInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.dateUpdated}">
				<li class="fieldcontain">
					<span id="dateUpdated-label" class="property-label"><g:message code="account.dateUpdated.label" default="Date Updated" /></span>
					
						<span class="property-value" aria-labelledby="dateUpdated-label"><g:formatDate date="${accountInstance?.dateUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			</td><td>

					<div class="property-list account">

						<table><tr><th>Reviewer</th><th>ThumbsUp</th><th>Comments</th></tr>
						<tr>
						<g:each in="${accountInstance.reviews}" var="rev">
							<tr><td>
								<h3>${rev.reviewer.name} </h3>
							</td>
							<td>
								${fieldValue(bean: rev, field: "thumbsUp")}
							</td>
								<td>
									${fieldValue(bean: rev, field: "comments")}
								</td>
							</tr>
						</g:each>
						</tr>
						</table><br>

					</div>

			</td></tr></table>
			<h1>Address</h1>
			<div class="property-list account">
				<g:each in="${accountInstance.address.sort{a,b->b.address1.compareTo(a.address1)}}" var="addr">
					<h3>${fieldValue(bean: addr, field: "addressName")} </h3><br/>
					${fieldValue(bean: addr, field: "address1")} <br/>
					${fieldValue(bean: addr, field: "address2")} <br/>
					${fieldValue(bean: addr, field: "city")},${fieldValue(bean: addr, field: "state")} ${fieldValue(bean: addr, field: "zip")} <br/> <br/>
				</g:each>

			</div>
			<g:form url="[resource:accountInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${accountInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

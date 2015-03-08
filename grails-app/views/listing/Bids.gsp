<%@ page import="auction.Listing" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'listing.label', default: 'Listing')}" />
    <title>Bids</title>
</head>
<body>
<a href="#list-listing" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><a class="list" controller="listing" action="show">Listing Details</a></li>
        <li><a class="create" controller="bid" action="create">Bid</a></li>

    </ul>
</div>
<div id="list-listing" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <th>Bids for Listing: ${Listing.name}</th>

            <g:sortableColumn property="listingName" title="${message(code: 'listing.listingName.label', default: 'Listing Name')}" />

            <g:sortableColumn property="listingDays" title="${message(code: 'listing.listingDays.label', default: 'Listing Days')}" />

            <g:sortableColumn property="startingPrice" title="${message(code: 'listing.startingPrice.label', default: 'Starting Price')}" />

            <g:sortableColumn property="startDate" title="${message(code: 'listing.startDate.label', default: 'Start Date')}" />

            <th><g:message code="listing.deliveredby.label" default="Deliveredby" /></th>

        </tr>
        </thead>
        <tbody>
        <g:each in="${listingInstanceList}" status="i" var="listingInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show" id="${listingInstance.id}">${fieldValue(bean: listingInstance, field: "owner")}</g:link></td>

                <td>${fieldValue(bean: listingInstance, field: "listingName")}</td>

                <td>${fieldValue(bean: listingInstance, field: "listingDays")}</td>

                <td>${fieldValue(bean: listingInstance, field: "startingPrice")}</td>

                <td><g:formatDate date="${listingInstance.startDate}" /></td>

                <td>${fieldValue(bean: listingInstance, field: "deliveredby")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${listingInstanceCount ?: 0}" />
    </div>
</div>
</body>
</html><%--
  Created by IntelliJ IDEA.
  User: Kenji
  Date: 3/7/2015
  Time: 9:16 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>

</body>
</html>
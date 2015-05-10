<%@ page import="auction.User; auction.Account; org.springframework.security.core.context.SecurityContextHolder" %>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>Awesome Auction</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
	<link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
	<link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
	<asset:stylesheet src="application.css"/>
<sec:ifLoggedIn>
	<script>
		<% def user = SecurityContextHolder.getContext().getAuthentication().getPrincipal()
        if (user?.username) {
            def userName =user.username
            def fullName=""
            def accountId=0
            if (userName>""){
                accountId=Account.findByUser(auction.User.findByUsername(userName)).id
                fullName=Account.findByUser(auction.User.findByUsername(userName)).name
            }

        %>
		var loggedInUser = {
			username: '<%=  userName %>',
			accountId: '<%= accountId %>',
			fullName:'<%=fullName  %>'


		};
		<% } %>
	</script>
	</sec:ifLoggedIn>
	<asset:javascript src="application.js"/>
</head>

<body ng-app="app">

<div ng-include="'templates/heading.html'">

</div>
<table style="width:100%">
	<tr><td> </td><td style="vertical-align:bottom; text-align: right"><div class="greeting" ng-controller="welcomeController">
		<sec:ifLoggedIn>
			Logged in as:{{ loggedInUser.fullName }} [ <g:link controller='logout' action=''>Logout</g:link> ]
		</sec:ifLoggedIn>
		<sec:ifNotLoggedIn>
			[<g:link controller='login' action=''> login</g:link> ]
			 <a href="#/account">New Account</a><br/>
		</sec:ifNotLoggedIn>
	</div></td></tr>
</table>
<table style="width:100%">
<tr><td style="width:20%">
<sec:ifLoggedIn>
	<div ng-include="'templates/menu.html'">

	</div>
</sec:ifLoggedIn>
</td><td>
	<ng-view></ng-view>

</td></tr></table>
<div class="footer" role="contentinfo"></div>

<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
</body>
</html>

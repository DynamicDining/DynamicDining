<!doctype html>
<html>
<head>
<title>Java Web Programming: Success Page</title>
<meta name="description" content="This is a JSP example of a success page you may send users to via the RequestDispatcher when your application completes an action successfully." />
<link rel="icon" href="assets/img/favicon.ico">
<%@ include file="include/styles.jsp"  %>
</head>
<body>
<div id="wrapper">
	<header>
		<h1>Success</h1>
	</header>
	<%@ include file="include/navigation.jsp" %>
	<section class="content">
		<article class="single">
			<h2>Yay!</h2>
			<hr>
			<p>${success}</p>
		</article>
<%@ include file="include/footer.jsp"  %>
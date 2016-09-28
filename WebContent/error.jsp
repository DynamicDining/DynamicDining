<!doctype html>
<html>
<head>
<title>Java Web Programming: Error Page</title>
<meta name="description" content="This is a JSP example that demonstrates how to output a filtered list of Movies to a web page." />
<link rel="icon" href="assets/img/favicon.ico">
<%@ include file="include/styles.jsp"  %>
</head>
<body>
<div id="wrapper">
	<header>
		<h1>Error</h1>
	</header>
	<%@ include file="include/navigation.jsp" %>
	<section class="content">
		<article class="single">
			<h2>Oops...</h2>
			<hr>
			<p>${error}</p>
		</article>
<%@ include file="include/footer.jsp"  %>
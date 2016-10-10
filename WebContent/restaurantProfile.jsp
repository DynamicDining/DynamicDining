<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="include/pageHeader.jsp">
	<jsp:param value="Java Web Programming: Restaurant Search" name="pageTitle"/>
	<jsp:param value="This is a JSP example that demonstrates how to use a form to search for a Restaurant from our Spreadsheet." name="pageDescription"/>
</jsp:include>
<article class="single">
	<c:choose>
		<c:when test="${empty restaurant}">
			<article class="single">
				<h2>Oops!</h2>
				<hr>
				<p>Sorry, the database is empty.</p>
			</article>
		</c:when>
		<c:otherwise>
			<a href="CreateReview"></a>
		</c:otherwise>
	</c:choose>
	<a href="CreateReview"></a>
</article>
<%@ include file="include/footer.jsp"  %>
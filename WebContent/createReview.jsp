<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="include/pageHeader.jsp">
	<jsp:param value="Java Web Programming: Restaurant Search" name="pageTitle"/>
	<jsp:param value="This is a JSP example that demonstrates how to use a form to search for a Restaurant from our Spreadsheet." name="pageDescription"/>
</jsp:include>
<article class="single">
	<h2>Create Review for ${restaurant.name}</h2>
	<hr>
	<div>
		<form action="CreateReview" method="post">
				<label for="name">Name</label>
				<input required name="name" />
				
				<textarea required name="review"></textarea>
				
				<label for="rating">Rating</label>
				<input required name="rating" />
				<input class="btn btn-primary btn-lg button" type="submit" value="Review" />
		</form>
	</div>
</article>
<%@ include file="include/footer.jsp"  %>
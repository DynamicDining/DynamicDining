<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="include/pageHeader.jsp">
	<jsp:param value="Restaurant Search"
		name="pageTitle" />
	<jsp:param
		value="This is a JSP example that demonstrates how to use a form to search for a Restaurant from our Spreadsheet."
		name="pageDescription" />
</jsp:include>
<c:choose>
	<c:when test="${empty restaurants}">
		<article class="single">
			<h2>Oops!</h2>
			<hr>
			<p>Sorry, we couldn't find that restaurant.</p>
		</article>
	</c:when>
	<c:otherwise>
		<article class="single">
			<c:forEach var="restaurant" items="${restaurants}">

				<h2>${restaurant.name}</h2>
				<hr>
				<p>${restaurant.address}</p>
				<p>${restaurant.city}, ${restaurant.state} ${restaurant.zipCode}</p>
				<p>${restaurant.telephoneNumber}</p>
				<p>
					Website: <a href="${restaurant.website}">${restaurant.name}</a>
				</p>
				<p>Rating: ${restaurant.rating}</p>
				
				<p>ID: ${restaurant.id}</p>

				<hr>
				<div>
					<h3>Create a Review</h3>
					<form action="CreateReview" method="post">
						<div class="form-group">
							
							<input id="restaurantID" name="restaurantID" type="hidden" value="${restaurant.id }">
							
							<label for="author" ><strong>Name:</strong></label>
							<input id="author" name="author" class="formLabel">
							
							<label for="reviewContent" ><strong>Review:</strong></label>
							<textarea id="reviewContent" name="reviewContent" class="formLabel"></textarea>
							
							<label for="rating" ><strong>Rating:</strong></label>
							<input id="rating" name="rating" class="formLabel">
							
							<input class="btn btn-primary btn-lg>" name="submit" type="submit" value="Add Rating">
						</div>
					</form>	
					<br>
									
					<c:forEach var="review" items="${reviews}">
					<div>
						<hr>
						<h4>${review.author}</h4>
						<p>Review: ${review.review}</p>
						<p>Rating: ${review.rating}</p>
					</div>
					</c:forEach>
					
				</div>

			</c:forEach>
		</article>

	</c:otherwise>
</c:choose>

<%@ include file="include/footer.jsp"%>
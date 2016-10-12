<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="include/pageHeader.jsp">
	<jsp:param value="Java Web Programming: Restaurant Search"
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
						<label for="name">Name</label> <input required name="name" />

						<textarea required name="review"></textarea>

						<label for="rating">Rating</label> <input required name="rating" />
						<input class="btn btn-primary btn-lg button" type="submit"
							value="Review" />
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

				<a href="CreateReview"></a>

			</c:forEach>
		</article>

	</c:otherwise>
</c:choose>

<%@ include file="include/footer.jsp"%>
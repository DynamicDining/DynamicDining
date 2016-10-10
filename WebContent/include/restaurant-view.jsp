<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
	<c:when test="${empty restaurants}">
		<article class="single">
			<h2>Oops!</h2>
			<hr>
			<p>Sorry, the database is empty.</p>
		</article>
	</c:when>
	<c:otherwise>
		<c:forEach var="restaurant" items="${restaurants}">
			<article class="single">
				<h2>${restaurant.name}</h2>
				<hr>
				<p>${restaurant.telephoneNumber}. 
				<a href="RestaurantProfile?name=${restaurant.name}">See Profile</a>
				</p>
			</article>
		</c:forEach>
	</c:otherwise>
</c:choose>
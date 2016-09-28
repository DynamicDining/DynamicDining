<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
	<c:when test="${empty movies}">
		<article class="single">
			<h2>Oops!</h2>
			<hr>
			<p>Sorry, the database is empty.</p>
		</article>
	</c:when>
	<c:otherwise>
		<c:forEach var="movie" items="${movies}">
			<article class="single">
				<h2>${movie.title}</h2>
				<hr>
				<p>${movie.title}, directed by ${movie.director} is ${movie.minutes} minutes long. 
				Starring: 
				<c:forEach var="star" items="${movie.stars}" varStatus="loopCount">
					${star.name}<c:if test="${!loopCount.last}"> and </c:if></c:forEach>.
				</p>
			</article>
		</c:forEach>
	</c:otherwise>
</c:choose>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="include/pageHeader.jsp">
	<jsp:param value="This is a JSP example that demonstrates how to use a form to edit a movie to our database." name="pageDescription"/>
</jsp:include>
<article class="single">
	<h2>Edit</h2>
	<hr>
	<form action="DeleteMovie" method="post" class="newForm">
			<select size="10" name="movieList" id="listBox" style="width: 300px">
				<c:forEach var="movie" items="${movies}">
					<option value='{"id": "${movie.id}",
									"title": "${movie.title}",
									"director": "${movie.director}",
									"minutes": "${movie.minutes}",
									"star1": "${movie.stars[0]}",
									"star2": "${movie.stars[1]}",
									"star3": "${movie.stars[2]}"}'>${movie.title}</option>
				</c:forEach>
			</select>
			<input class="btn btn-primary btn-lg button" type="submit" value="Delete Movie" />
	</form>
	
	<form action="UpdateMovie" method="post" class="newForm">
		<label for="id"><strong>ID:</strong></label>
		<input readonly="readonly" name="id" value="${movie.id}"/>
		<br>
		<label for="title"><strong>Title:</strong></label>
		<input required name="title" />
		<br>
		<label for="director"><strong>Director:</strong></label>
		<input required name="director" />
		<br>
		<label for="minutes"><strong>Minutes:</strong></label>
		<input required name="minutes" type="number" min="0" max="1000" />
		<br>
		<label for="star_1"><strong>Actor/Actress:</strong></label>
		<input required name="star_1" />
		<br>
		<label for="star_2"><strong>Actor/Actress:</strong></label>
		<input required name="star_2" />
		<br>
		<label for="star_3"><strong>Actor/Actress:</strong></label>
		<input required name="star_3" />
		<br>
		<input class="btn btn-primary btn-lg button" type="submit" value="Update Movie" />
	</form>
</article>
<%@ include file="include/footer.jsp" %>
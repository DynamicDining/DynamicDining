<jsp:include page="include/pageHeader.jsp">
	<jsp:param value="This is a JSP example that demonstrates how to use a form to add a movie to our database." name="pageDescription"/>
</jsp:include>
<article class="single">
	<h2>Add Movie</h2>
	<hr>
	<form action="AddMovie" method="post" class="newForm">
		<label for="title"><strong>Title:</strong></label>
		<input required name="title" />
		
		<label for="director"><strong>Director:</strong></label>
		<input required name="director" />
		
		<label for="minutes"><strong>Minutes:</strong></label>
		<input required name="minutes" type="number" />
		
		<label for="actor_1"><strong>Actor/Actress:</strong></label>
		<input required name="actor_1" />
		
		<label for="actor_2"><strong>Actor/Actress:</strong></label>
		<input required name="actor_2" />
						
		<label for="actor_3"><strong>Actor/Actress:</strong></label>
		<input required name="actor_3" />
		
		<input class="btn btn-primary btn-lg button" type="submit" value="Add Movie" />
	</form>
</article>
<%@ include file="include/footer.jsp"  %>
<jsp:include page="include/pageHeader.jsp">
	<jsp:param value="Java Web Programming: Movie Search" name="pageTitle"/>
	<jsp:param value="This is a JSP example that demonstrates how to use a form to search for a Movie from our Spreadsheet." name="pageDescription"/>
</jsp:include>
<article class="single">
	<h2>Search</h2>
	<hr>
	<div class="searchForm">
		<form action="SearchByTitle" method="post">
				<label for="title"><strong>Search by Title:</strong></label>
				<input required name="title" />
				<input class="btn btn-primary btn-lg button" type="submit" value="Search" />
		</form>
	</div>
	<div class="searchForm">
		<form action="SearchByDirector" method="post">
				<label for="director"><strong>Search by Director:</strong></label>
				<input required name="director" />
				<input class="btn btn-primary btn-lg button" type="submit" value="Search" />
		</form>
	</div>
</article>
<%@ include file="include/footer.jsp"  %>
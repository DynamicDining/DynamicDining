<jsp:include page="include/pageHeader.jsp">
	<jsp:param value="This is a JSP used to populate the Movie database." name="pageDescription"/>
</jsp:include>
<article class="single">
	<h2>Populate</h2>
	<hr>
	<div class="searchForm">
		<form action="PopulateDatabase" method="post">
			<label for="submit"><strong>Build database</strong></label>
			<input name="submit" class="btn btn-primary btn-lg button" type="submit" value="Populate" />
		</form>
	</div>
</article>
<%@ include file="include/footer.jsp"  %>
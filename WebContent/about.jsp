<jsp:include page="include/pageHeader.jsp">
	<jsp:param value="Java Web Programming: Restaurant Search" name="pageTitle"/>
	<jsp:param value="This is a JSP example that demonstrates the About Us page." name="pageDescription"/>
</jsp:include>
<article class="single">
	<h2>About Us</h2>
	<hr>

		<h6>
		For those looking for a remarkable restaurant experience, Dine or Ditch
		helps guide you to the best restaurants in town.  Dine or Ditch provides 
		first-hand access to the world's most exciting restaurants that cover every
		taste and budget.  Dine or Ditch collects and analyzes reviews that come from enthusiastic
		diners like you.  Our review system is easy to understand and is intended to inform you 
		about remarkable restaurants in your area.	
		</h6>
	
	<div class="searchForm">
		<form action="SearchByName" method="post">
				<label for="title"><strong>Contact Us</strong></label>
				<input required name="title" />
				<input class="btn btn-primary btn-lg button" type="submit" value="Search" />
		</form>		
	</div>

</article>
<%@ include file="include/footer.jsp"  %>
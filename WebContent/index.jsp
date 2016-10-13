<jsp:include page="include/pageHeader.jsp">
	<jsp:param value="This is a servlet for the homepage of our site."
		name="pageDescription" />
</jsp:include>
<article class="about">
	<h2>Dynamic Dining</h2>
	<hr>

	<!-- 	<div id="imageRotator" class="imageRotator">
		<div class="imageContent">
			<img src="assets/img/dish.jpg">
		</div>
		<div class="imageContent">
			<img src="assets/img/jelo.jpg">
		</div>
		<div class="imageContent">
			<img src="assets/img/kanoli.jpg">
		</div>
		<div class="imageContent">
			<img src="assets/img/klub.jpg">
		</div>
		<div class="imageContent">
			<img src="assets/img/pizza.jpg">
		</div>
	</div> -->

	<div class="slides">
		<ul class="rslides">
			<li><img src="assets/img/dish.jpg"></li>
			<li><img src="assets/img/jelo.jpg"></li>
			<li><img src="assets/img/kanoli.jpg"></li>
		</ul>
	</div>

	<p>Welcome to Dynamic Dining, the best way to get info on your
		local restaurants!</p>
	<p>
		On this site you will be able search through some local restaurants as
		well as leave comments about restaurants you may have visited! If you
		want to leave us a comment about our site, go ahead and visit our <a
			href="about.jsp">about page</a>!
	</p>
</article>
<jsp:include page="include/footer.jsp"></jsp:include>
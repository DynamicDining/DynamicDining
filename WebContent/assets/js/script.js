$(function(){
	$("#listBox").change(function(){

		var movieJSON = $(this).val();
		var $movie = $.parseJSON(movieJSON);

		$(".newForm input[name=id]").val($movie.id);
		$(".newForm input[name=title]").val($movie.title);
		$(".newForm input[name=director]").val($movie.director);
		$(".newForm input[name=minutes]").val($movie.minutes);
		$(".newForm input[name=star_1]").val($movie.star1);
		$(".newForm input[name=star_2]").val($movie.star2);
		$(".newForm input[name=star_3]").val($movie.star3);
		
	});
});
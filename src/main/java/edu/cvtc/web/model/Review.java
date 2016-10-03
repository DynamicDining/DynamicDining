package edu.cvtc.web.model;

public class Review {

	private int id;
	private String review;
	private String author;
	private int rating;

	public Review(int id, String review, String author, int rating) {
		this.id = id;
		this.review = review;
		this.author = author;
		this.rating = rating;
	}

	public Review(String review, String author, int rating) {
		this.review = review;
		this.author = author;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}

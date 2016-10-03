package edu.cvtc.web.model;

public class Review {

	private int id;
	private String review;
	private String author;

	public Review(int id, String review, String author) {
		this.id = id;
		this.review = review;
		this.author = author;
	}

	public Review(String review, String author) {
		this.review = review;
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Review(int id, String review) {
		this.id = id;
		this.review = review;
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

}

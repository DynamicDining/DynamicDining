package edu.cvtc.web.model;

/**
 * The Class Review.
 */
public class Review {

	/** The id. */
	private int id;
	
	/** The review. */
	private String review;
	
	/** The author. */
	private String author;
	
	/** The rating. */
	private int rating;

	/**
	 * Instantiates a new review.
	 *
	 * @param id the id
	 * @param review the review
	 * @param author the author
	 * @param rating the rating
	 */
	public Review(int id, String review, String author, int rating) {
		this.id = id;
		this.review = review;
		this.author = author;
		this.rating = rating;
	}

	/**
	 * Instantiates a new review.
	 *
	 * @param review the review
	 * @param author the author
	 * @param rating the rating
	 */
	public Review(String review, String author, int rating) {
		this.review = review;
		this.author = author;
		this.rating = rating;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the review.
	 *
	 * @return the review
	 */
	public String getReview() {
		return review;
	}

	/**
	 * Sets the review.
	 *
	 * @param review the new review
	 */
	public void setReview(String review) {
		this.review = review;
	}

	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

}

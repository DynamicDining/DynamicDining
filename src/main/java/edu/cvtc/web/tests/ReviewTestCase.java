package edu.cvtc.web.tests;

import org.junit.Test;

import edu.cvtc.web.model.Review;
import junit.framework.TestCase;

/**
 * The Class ReviewTestCase.
 */
public class ReviewTestCase extends TestCase {

	/** The expected ID. */
	private final int expectedID = 1;
	
	/** The expected review. */
	private final String expectedReview = "good eating";
	
	/** The expected author. */
	private final String expectedAuthor = "Fong Lor";
	
	/** The expected rating. */
	private final int expectedRating = 1;

	/** The review. */
	private final Review review = new Review(expectedID, expectedReview, expectedAuthor, expectedRating);

	/**
	 * Test ID.
	 */
	@Test
	public void testID() {
		final int id = review.getId();
		assertEquals(expectedID, id);
	}

	/**
	 * Test review.
	 */
	@Test
	public void testReview() {
		final String review2 = review.getReview();
		assertEquals(expectedReview, review2);
	}

	/**
	 * Test author.
	 */
	@Test
	public void testAuthor() {
		final String author = review.getAuthor();
		assertEquals(expectedAuthor, author);
	}

	/**
	 * Test rating.
	 */
	@Test
	public void testRating() {
		final int rating = review.getRating();
		assertEquals(expectedRating, rating);
	}

}

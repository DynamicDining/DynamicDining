package edu.cvtc.web.tests;

import org.junit.Test;

import edu.cvtc.web.model.Review;
import junit.framework.TestCase;

public class ReviewTestCase extends TestCase {

	private final int expectedID = 1;
	private final String expectedReview = "good eating";
	private final String expectedAuthor = "Fong Lor";
	private final int expectedRating = 1;

	private final Review review = new Review(expectedID, expectedReview, expectedAuthor, expectedRating);

	@Test
	public void testID() {
		final int id = review.getId();
		assertEquals(expectedID, id);
	}

	@Test
	public void testReview() {
		final String review2 = review.getReview();
		assertEquals(expectedReview, review2);
	}

	@Test
	public void testAuthor() {
		final String author = review.getAuthor();
		assertEquals(expectedAuthor, author);
	}

	@Test
	public void testRating() {
		final int rating = review.getRating();
		assertEquals(expectedRating, rating);
	}

}

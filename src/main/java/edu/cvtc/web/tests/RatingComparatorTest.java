package edu.cvtc.web.tests;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class RatingComparatorTest.
 */
public class RatingComparatorTest {

	/** The expected rating 1. */
	private final int expectedRating1 = 1;
	
	/** The expected rating 2. */
	private final int expectedRating2 = 1;
	
	/** The expected rating 3. */
	private final int expectedRating3 = 2;
	
	/**
	 * Compare test 1.
	 */
	@Test
	public void compareTest1() {
		int result = Integer.compare(expectedRating1, expectedRating2);
		assertEquals(0, result);
	}
	
	/**
	 * Compare test 2.
	 */
	@Test
	public void compareTest2() {
		int result = Integer.compare(expectedRating3, expectedRating2);
		assertEquals(1, result);
	}

}

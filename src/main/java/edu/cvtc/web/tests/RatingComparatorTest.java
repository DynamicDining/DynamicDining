package edu.cvtc.web.tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class RatingComparatorTest {

	private final int expectedRating1 = 1;
	private final int expectedRating2 = 1;
	private final int expectedRating3 = 2;
	
	@Test
	public void compareTest1() {
		int result = Integer.compare(expectedRating1, expectedRating2);
		assertEquals(0, result);
	}
	
	@Test
	public void compareTest2() {
		int result = Integer.compare(expectedRating3, expectedRating2);
		assertEquals(1, result);
	}

}

package edu.cvtc.web.tests;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class MatchesNamePredicateTest.
 */
public class MatchesNamePredicateTest {

	/** The expected name 1. */
	private final String expectedName1 = "McDonalds";
	
	/** The expected name 2. */
	private final String expectedName2 = "McDonalds";
	
	/** The expected name 3. */
	private final String expectedName3 = "Hardees";
	
	/**
	 * Apply test 1.
	 */
	@Test
	public void applyTest1() {
		boolean result = expectedName1.toLowerCase().contains(expectedName2.toLowerCase());
		assertEquals(true, result);
	}
	
	/**
	 * Apply test 2.
	 */
	@Test
	public void applyTest2() {
		boolean result = expectedName3.toLowerCase().contains(expectedName2.toLowerCase());
		assertEquals(false, result);
	}

}


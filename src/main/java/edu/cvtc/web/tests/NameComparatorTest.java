package edu.cvtc.web.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The Class NameComparatorTest.
 */
public class NameComparatorTest {

	/** The expected name 1. */
	private final String expectedName1 = "McDonalds";
	
	/** The expected name 2. */
	private final String expectedName2 = "McDonalds";
	
	/** The expected name 3. */
	private final String expectedName3 = "Hardees";
	
	/**
	 * Compare test 1.
	 */
	@Test
	public void compareTest1() {
		int result = expectedName1.toLowerCase().compareTo(expectedName2.toLowerCase());
		assertEquals(0, result);
	}
	
	/**
	 * Compare test 2.
	 */
	public void compareTest2() {
		int result = expectedName3.toLowerCase().compareTo(expectedName2.toLowerCase());
		assertEquals(1, result);
	}

}

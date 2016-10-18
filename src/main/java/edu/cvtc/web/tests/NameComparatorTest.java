package edu.cvtc.web.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NameComparatorTest {

	private final String expectedName1 = "McDonalds";
	private final String expectedName2 = "McDonalds";
	private final String expectedName3 = "Hardees";
	
	@Test
	public void compareTest1() {
		int result = expectedName1.toLowerCase().compareTo(expectedName2.toLowerCase());
		assertEquals(0, result);
	}
	
	public void compareTest2() {
		int result = expectedName3.toLowerCase().compareTo(expectedName2.toLowerCase());
		assertEquals(1, result);
	}

}

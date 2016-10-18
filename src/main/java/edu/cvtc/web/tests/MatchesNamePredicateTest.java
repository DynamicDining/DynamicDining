package edu.cvtc.web.tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatchesNamePredicateTest {

	private final String expectedName1 = "McDonalds";
	private final String expectedName2 = "McDonalds";
	private final String expectedName3 = "Hardees";
	
	@Test
	public void applyTest1() {
		boolean result = expectedName1.toLowerCase().contains(expectedName2.toLowerCase());
		assertEquals(true, result);
	}
	
	@Test
	public void applyTest2() {
		boolean result = expectedName3.toLowerCase().contains(expectedName2.toLowerCase());
		assertEquals(false, result);
	}

}


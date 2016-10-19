package edu.cvtc.web.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.cvtc.web.util.StringUtils;

public class StringUtilsTest {

	private final String name = "McDonalds";
	private final double number = 1;
	private final String strNumber = "1";

	@Test
	public void testIsNotEmpty() {
		final boolean result = StringUtils.isNotEmpty(name);

		assertEquals(true, result);
	}

	@Test
	public void testIsANumber() {
		final boolean result = StringUtils.isANumber(strNumber);

		assertEquals(true, result);
	}

	@Test
	public void testDoubleToString() {
		final String result = StringUtils.doubleToString(number);

		assertEquals(strNumber, result);
	}

}

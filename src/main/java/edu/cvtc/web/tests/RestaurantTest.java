package edu.cvtc.web.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.cvtc.web.model.Restaurant;
import edu.cvtc.web.util.Constants;

/**
 * The Class RestaurantTest.
 */
public class RestaurantTest {

	/** The expected id. */
	private final int expectedId = 1;
	
	/** The expected name. */
	private final String expectedName = "McDonalds";
	
	/** The expected address. */
	private final String expectedAddress = "123 Main St";
	
	/** The expected city. */
	private final String expectedCity = "Eau Claire";
	
	/** The expected state. */
	private final String expectedState = "WI";
	
	/** The expected zip code. */
	private final String expectedZipCode = "54703";
	
	/** The expected telephone number. */
	private final String expectedTelephoneNumber = "715-555-5555";
	
	/** The expected website. */
	private final String expectedWebsite = "www.mcdonalds.com";
	
	/** The expected rating. */
	private final double expectedRating = 1;

	/** The restaurant. */
	private final Restaurant restaurant = new Restaurant(expectedId, expectedName, expectedAddress, expectedCity,
			expectedState, expectedZipCode, expectedTelephoneNumber, expectedWebsite, expectedRating);

	/**
	 * Test ID.
	 */
	@Test
	public void testID() {
		final int id = restaurant.getId();
		assertEquals(expectedId, id);
	}

	/**
	 * Test name.
	 */
	@Test
	public void testName() {
		final String name = restaurant.getName();
		assertEquals(expectedName, name);
	}

	/**
	 * Test address.
	 */
	@Test
	public void testAddress() {
		final String address = restaurant.getAddress();
		assertEquals(expectedAddress, address);
	}

	/**
	 * Test city.
	 */
	@Test
	public void testCity() {
		final String city = restaurant.getCity();
		assertEquals(expectedCity, city);
	}

	/**
	 * Test state.
	 */
	@Test
	public void testState() {
		final String state = restaurant.getState();
		assertEquals(expectedState, state);
	}

	/**
	 * Test zip code.
	 */
	@Test
	public void testZipCode() {
		final String zipCode = restaurant.getZipCode();
		assertEquals(expectedZipCode, zipCode);
	}

	/**
	 * Test telephone number.
	 */
	@Test
	public void testTelephoneNumber() {
		final String telephoneNumber = restaurant.getTelephoneNumber();
		assertEquals(expectedTelephoneNumber, telephoneNumber);
	}

	/**
	 * Test website.
	 */
	@Test
	public void testWebsite() {
		final String website = restaurant.getWebsite();
		assertEquals(expectedWebsite, website);
	}

	/**
	 * Test rating.
	 */
	@Test
	public void testRating() {
		final double rating = restaurant.getRating();
		assertEquals(expectedRating, rating, Constants.DELTA);
	}

}

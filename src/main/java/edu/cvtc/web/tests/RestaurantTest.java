package edu.cvtc.web.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.cvtc.web.model.Restaurant;
import edu.cvtc.web.util.Constants;

public class RestaurantTest {

	private final int expectedId = 1;
	private final String expectedName = "McDonalds";
	private final String expectedAddress = "123 Main St";
	private final String expectedCity = "Eau Claire";
	private final String expectedState = "WI";
	private final String expectedZipCode = "54703";
	private final String expectedTelephoneNumber = "715-555-5555";
	private final String expectedWebsite = "www.mcdonalds.com";
	private final double expectedRating = 1;

	private final Restaurant restaurant = new Restaurant(expectedId, expectedName, expectedAddress, expectedCity,
			expectedState, expectedZipCode, expectedTelephoneNumber, expectedWebsite, expectedRating);

	@Test
	public void testID() {
		final int id = restaurant.getId();
		assertEquals(expectedId, id);
	}

	@Test
	public void testName() {
		final String name = restaurant.getName();
		assertEquals(expectedName, name);
	}

	@Test
	public void testAddress() {
		final String address = restaurant.getAddress();
		assertEquals(expectedAddress, address);
	}

	@Test
	public void testCity() {
		final String city = restaurant.getCity();
		assertEquals(expectedCity, city);
	}

	@Test
	public void testState() {
		final String state = restaurant.getState();
		assertEquals(expectedState, state);
	}

	@Test
	public void testZipCode() {
		final String zipCode = restaurant.getZipCode();
		assertEquals(expectedZipCode, zipCode);
	}

	@Test
	public void testTelephoneNumber() {
		final String telephoneNumber = restaurant.getTelephoneNumber();
		assertEquals(expectedTelephoneNumber, telephoneNumber);
	}

	@Test
	public void testWebsite() {
		final String website = restaurant.getWebsite();
		assertEquals(expectedWebsite, website);
	}

	@Test
	public void testRating() {
		final double rating = restaurant.getRating();
		assertEquals(expectedRating, rating, Constants.DELTA);
	}

}

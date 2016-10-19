package edu.cvtc.web.model;

/**
 * The Class Restaurant.
 *
 * @author Project Skeleton
 */
public class Restaurant {

	/** The id. */
	private int id;
	
	/** The name. */
	private String name;
	
	/** The address. */
	private String address;
	
	/** The city. */
	private String city;
	
	/** The state. */
	private String state;
	
	/** The zip code. */
	private String zipCode;
	
	/** The telephone number. */
	private String telephoneNumber;
	
	/** The website. */
	private String website;
	
	/** The rating. */
	private double rating;

	/**
	 * Instantiates a new restaurant.
	 *
	 * @param name the name
	 * @param address the address
	 * @param city the city
	 * @param state the state
	 * @param zipCode the zip code
	 * @param telephoneNumber the telephone number
	 * @param website the website
	 */
	public Restaurant(String name, String address, String city, String state, String zipCode, String telephoneNumber,
			String website) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.telephoneNumber = telephoneNumber;
		this.website = website;
	}

	/**
	 * Instantiates a new restaurant.
	 *
	 * @param id the id
	 * @param name the name
	 * @param address the address
	 * @param city the city
	 * @param state the state
	 * @param zipCode the zip code
	 * @param telephoneNumber the telephone number
	 * @param website the website
	 */
	public Restaurant(int id, String name, String address, String city, String state, String zipCode,
			String telephoneNumber, String website) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.telephoneNumber = telephoneNumber;
		this.website = website;
	}

	/**
	 * Instantiates a new restaurant.
	 *
	 * @param id the id
	 * @param name the name
	 * @param address the address
	 * @param city the city
	 * @param state the state
	 * @param zipCode the zip code
	 * @param telephoneNumber the telephone number
	 * @param website the website
	 * @param rating the rating
	 */
	public Restaurant(int id, String name, String address, String city, String state, String zipCode,
			String telephoneNumber, String website, double rating) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.telephoneNumber = telephoneNumber;
		this.website = website;
		this.rating = rating;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the zip code.
	 *
	 * @return the zip code
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Sets the zip code.
	 *
	 * @param zipCode the new zip code
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Gets the telephone number.
	 *
	 * @return the telephone number
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * Sets the telephone number.
	 *
	 * @param telephoneNumber the new telephone number
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	/**
	 * Gets the website.
	 *
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * Sets the website.
	 *
	 * @param website the new website
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

}

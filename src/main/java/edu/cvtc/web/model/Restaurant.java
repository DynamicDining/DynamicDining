package edu.cvtc.web.model;

/**
 * @author Project Skeleton
 *
 */
public class Restaurant {

	private Integer id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String telephoneNumber;
	private String website;
	private double rating;

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

	public Restaurant(Integer id, String name, String address, String city, String state, String zipCode,
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

	public Restaurant(Integer id, String name, String address, String city, String state, String zipCode,
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

}

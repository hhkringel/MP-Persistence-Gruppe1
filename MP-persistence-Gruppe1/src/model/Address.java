package model;

public class Address {

	private String streetName;
	private int zipCode;
	private String city;
	private String country;
	private int addressID;
	
	
	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public Address(String streetName, int zipCode, String city, String country) {
		
		this.streetName = streetName;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
		
	}

	public String getStreetName() {
		return streetName;
	}


	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	public int getZipCode() {
		return zipCode;
	}


	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}
}

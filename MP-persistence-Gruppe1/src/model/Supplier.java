package model;

public class Supplier {
	private String name;
	private String phoneNo;
	private String email;
	private Address address;
	private String cvr;
	
	public Supplier(String name, String phoneNo, String email, Address address, String cvr) {
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.address = address;
		this.cvr = cvr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCvr() {
		return cvr;
	}

	public void setCvr(String cvr) {
		this.cvr = cvr;
	}
	
	

}

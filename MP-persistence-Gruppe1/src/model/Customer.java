package model;

public abstract class Customer {
	private String name;
	private String phoneNo;
	private String email;
	private Address address;
	private int customerID;
	
	
	
	public Customer(String name, String phoneNo, String email, Address address) {
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.address = address;
	}
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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
	
	

}

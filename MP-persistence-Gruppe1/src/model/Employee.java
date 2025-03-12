package model;

public class Employee {
	private String employeeID;
	private String name;
	private String phoneNo;
	private String email;
	private Address address;
	
	public Employee(String employeeID, String name, String phoneNo, String email, Address address) {
		this.employeeID = employeeID;
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.address = address;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
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

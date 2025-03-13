package model;

public class ClubCustomer extends Customer {
	private String cvr;

	public ClubCustomer(String name, String phoneNo, String email, Address address, String cvr) {
		super(name, phoneNo, email, address);
		this.customerType = "ClubCustomer";
		this.cvr = cvr;
	}

	public String getCvr() {
		return cvr;
	}

	public void setCvr(String cvr) {
		this.cvr = cvr;
	}
	
}

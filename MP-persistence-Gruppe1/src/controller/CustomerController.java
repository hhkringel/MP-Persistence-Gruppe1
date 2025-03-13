package controller;

import db.CustomerDB;
import db.CustomerDBIF;
import model.Address;
import model.ClubCustomer;
import model.Customer;
import model.PrivateCustomer;

public class CustomerController implements CustomerControllerIF{
	
	CustomerDBIF customerDB;
	
	public CustomerController() {
		customerDB = new CustomerDB();
	}
	
	@Override
	public PrivateCustomer createPrivateCustomer(String name, String phoneNo, String email, Address address) {
		PrivateCustomer newPrivateCustomer = new PrivateCustomer(name, phoneNo, email, address);
		insertCustomer(newPrivateCustomer);
		return (PrivateCustomer)findCustomerByPhoneNo(phoneNo);
	}

	@Override
	public ClubCustomer createClubCustomer(String name, String phoneNo, String email, Address address, String cvr) {
		ClubCustomer newClubCustomer = new ClubCustomer(name, phoneNo, email, address, cvr);
		insertCustomer(newClubCustomer);
		return (ClubCustomer)findCustomerByPhoneNo(phoneNo);
	}

	@Override
	public Customer findCustomerByPhoneNo(String phoneNo) {
		customerDB.findCustomerByPhoneNo(phoneNo);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDB.updateCustomer(customer);
	}

	@Override
	public void insertCustomer(Customer customer) {
		customerDB.insertCustomer(customer);
	}

}

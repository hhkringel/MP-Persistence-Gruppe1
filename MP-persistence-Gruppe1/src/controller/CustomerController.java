package controller;

import db.CustomerDBIF;
import model.Address;
import model.ClubCustomer;
import model.Customer;
import model.PrivateCustomer;

public class CustomerController implements CustomerControllerIF {
	private CustomerDBIF customerDB;
	
	public CustomerController() {
		
	}

	@Override
	public PrivateCustomer createPrivateCustomer(String name, String phoneNo, String email, Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClubCustomer createClubCustomer(String name, String phoneNo, String email, Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findCustomerByPhoneNo(String phoneNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

}

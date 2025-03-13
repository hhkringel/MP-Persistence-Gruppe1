package controller;

import model.Address;
import model.ClubCustomer;
import model.Customer;
import model.PrivateCustomer;

public interface CustomerControllerIF {
	
	public PrivateCustomer createPrivateCustomer(String name, String phoneNo, String email, Address address);
	
	public ClubCustomer createClubCustomer(String name, String phoneNo, String email, Address address, String cvr);
	
	public Customer findCustomerByPhoneNo(String phoneNo);
	
	public void updateCustomer(Customer customer);
	
	public void insertCustomer(Customer customer);

}

package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Address;
import model.ClubCustomer;
import model.Customer;
import model.PrivateCustomer;

public class CustomerDB implements CustomerDBIF {
	private static final String FIND_CUSTOMER_BY_PHONE_NO_QUERY = "SELECT * FROM customer WHERE phone_no = ?";
	private PreparedStatement findCustomerByPhoneNo;
	private static final String INSERT_CUSTOMER_QUERY = "INSERT INTO Customer (name, phone_no, email, address_id, customer_id, cvr)"
			+ "VALUES (?, ?, ?, ?, ?, ?)";
	private PreparedStatement insertCustomer;
	private static final String INSERT_ADDRESS_QUERY = "INSERT INTO address(street_name, zip_code, city, country)"
			+ "VALUES (?, ?, ?, ?)";
	private PreparedStatement insertAddress;
	
	public CustomerDB() {
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getInstance().getConnection();
		try {
			findCustomerByPhoneNo = con.prepareStatement(FIND_CUSTOMER_BY_PHONE_NO_QUERY);
			insertCustomer = con.prepareStatement(INSERT_CUSTOMER_QUERY);
;		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Customer findCustomerByPhoneNo(String phoneNo) {
		// TODO Auto-generated method stub
		Customer currentCustomer = null;
		try {
			findCustomerByPhoneNo.setString(1, phoneNo);
			ResultSet resultSet = findCustomerByPhoneNo.executeQuery();
			
			currentCustomer = buildObject(resultSet);
		} catch (SQLException e) {
			
		}
		return currentCustomer;
	}

	@Override
	public void insertCustomer(Customer customer) {
		
		
	}
	
	public Customer buildObject(ResultSet resultSet) {
	    Customer currentCustomer = null;
	    
	    try {
	        // Build Address directly from the ResultSet
	        Address address = new Address(
	            resultSet.getString("street_name"),
	            resultSet.getString("zip_code"),
	            resultSet.getString("city"),
	            resultSet.getString("country")
	        );

	        int customerId = resultSet.getInt("customer_id");
	        String name = resultSet.getString("name");
	        String phoneNo = resultSet.getString("phone_no");
	        String email = resultSet.getString("email");
	        String cvr = resultSet.getString("cvr");

	        if (cvr != null) {
	            // If CVR exists, create a ClubCustomer
	            currentCustomer = new ClubCustomer(name, phoneNo, email, address, cvr);
	        } else {
	            // Otherwise, create a PrivateCustomer
	            currentCustomer = new PrivateCustomer(name, phoneNo, email, address);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return currentCustomer;
	}


}

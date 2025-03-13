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
	private static final String INSERT_CUSTOMER_QUERY = "INSERT INTO Customer (phone_no, f_name, l_name, email, cvr, address_id, customer_type)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
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
		try {
					insertAddress.setString(1, customer.getAddress().getStreetName());
					insertAddress.setInt(2, customer.getAddress().getZipCode());
					insertAddress.setString(3, customer.getAddress().getCity());
					insertAddress.setString(4, customer.getAddress().getCountry());
					int affectedRows = insertAddress.executeUpdate();
					if (affectedRows == 0) {
						throw new SQLException("Failed to insert address, no rows affected");
					}
					
					insertCustomer.setString(1, customer.getPhoneNo());
					String[] name = customer.getName().split(" ");
					insertCustomer.setString(2, name[0]);
					insertCustomer.setString(3, name[1]);
					insertCustomer.setString(3, customer.getEmail());
					insertCustomer.setInt(5, customer.getAddress().getAddressID());
					insertCustomer.setString(6, customer.getCustomerType());
					
					if(customer instanceof ClubCustomer) {
						insertCustomer.setString(4, ((ClubCustomer) customer).getCvr());
					} else {
						insertCustomer.setNull(4, java.sql.Types.VARCHAR);
					}
					
					affectedRows = insertCustomer.executeUpdate();
					if (affectedRows == 0) {
						throw new SQLException("Failed to insert customer, no rows affected");
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Customer buildObject(ResultSet resultSet) {
	    Customer currentCustomer = null;
	    
	    try {
	        // Build Address directly from the ResultSet
	        Address address = new Address(
	            resultSet.getString("street_name"),
	            resultSet.getInt("zip_code"),
	            resultSet.getString("city"),
	            resultSet.getString("country")
	        );

	        String name = "" + resultSet.getString("f_name") + resultSet.getString("l_name");
	        String phoneNo = resultSet.getString("phone_no");
	        String email = resultSet.getString("email");
	        String cvr = resultSet.getString("cvr");

	        String customerType = resultSet.getString("customer_type");
			switch (customerType) {
			case "ClubCustomer":
				currentCustomer = new ClubCustomer(name, phoneNo, email, address, cvr);
				break;
			case "PrivateCustomer":
				currentCustomer = new PrivateCustomer(name, phoneNo, email, address);
				break;
			}
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return currentCustomer;
	}


}

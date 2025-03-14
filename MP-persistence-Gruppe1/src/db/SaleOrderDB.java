package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Product;
import model.SaleOrder;

public class SaleOrderDB implements SaleOrderDBIF {
	
	private static final String FIND_SALEORDER_BY_ID_QUERY = "SELECT * FROM SaleOrder WHERE order_no = ?";
	private PreparedStatement findSaleOrderByID;
	private static final String INSERT_SALEORDER_QUERY= "INSERT INTO SaleOrder (purchase_date, delivery_date, is_rent, customer_phone_no, employee_id)"
														+ " VALUES (?, ?, ?, ?, ?)";
	private PreparedStatement insertSaleOrder;
	
	
	public SaleOrderDB() {
		init();
	}
	
	public void init() {
		Connection con = DBConnection.getInstance().getDBcon();
		
		try {
			findSaleOrderByID = con.prepareStatement(FIND_SALEORDER_BY_ID_QUERY);
			insertSaleOrder = con.prepareStatement(INSERT_SALEORDER_QUERY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public SaleOrder findSaleOrderByID(int orderNo) {
		SaleOrder currentSaleOrder = null;
		
		
		try {
			findSaleOrderByID.setInt(1, orderNo);
			ResultSet resultSet = findSaleOrderByID.executeQuery();
			
			currentSaleOrder = buildObject(resultSet);
			
		} catch (SQLException e) {
			System.out.println("no object was built");
		}
		
		
		return currentSaleOrder;
	}

	
	private SaleOrder buildObject(ResultSet resultSet) {
		SaleOrder currentSaleOrder = null;
		
		try {
			if(resultSet.next()) {
				currentSaleOrder = new SaleOrder(resultSet.getDate("purchase_date").toLocalDate());
				currentSaleOrder.setOrderNo(resultSet.getInt("order_no"));
				if (resultSet.getDate("delivery_date") != null) {
					currentSaleOrder.setDeliveryDate(resultSet.getDate("delivery_date").toLocalDate());
				}
				currentSaleOrder.setRent(resultSet.getBoolean("is_rent"));
			}
			
		} catch(SQLException e) {
			System.out.println("No resultset found");
		}
		
		
		return currentSaleOrder;
	}

	@Override
	public void insertSaleOrder(SaleOrder saleOrder) {
		
		try {
			insertSaleOrder.setDate(1, Date.valueOf(saleOrder.getPurchaseDate()));
			if (saleOrder.getDeliveryDate() != null) {
				insertSaleOrder.setDate(2, Date.valueOf(saleOrder.getDeliveryDate()));
			}
			else {
				insertSaleOrder.setNull(2, java.sql.Types.VARCHAR);
			}
			insertSaleOrder.setBoolean(3, saleOrder.isRent());
			insertSaleOrder.setString(4, saleOrder.getCustomer().getPhoneNo());
			//insertSaleOrder.setInt(6, saleOrder.getEmployee().getEmployeeID());
			insertSaleOrder.setInt(5, 1);
			
			insertSaleOrder.executeUpdate();
		} catch (SQLException e) {
			
		}
		
	}

}

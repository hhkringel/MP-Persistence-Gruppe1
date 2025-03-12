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
	private static final String INSERT_SALEORDER_QUERY= "INSERT INTO SaleOrder (order_no, purchase_date, delivery_date, customer_id, employee_id, is_rent)"
														+ " VALUES (?, ?, ?, ?, ?, ?)";
	private PreparedStatement insertSaleOrder;
	
	
	public SaleOrderDB() {
		init();
	}
	
	public void init() {
		Connection con = DBConnection.getInstance().getConnection();
		
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
			
		}
		
		
		return currentSaleOrder;
	}

	
	private SaleOrder buildObject(ResultSet resultSet) {
		SaleOrder currentSaleOrder = null;
		
		try {
			currentSaleOrder = new SaleOrder(resultSet.getDate("purchase_date").toLocalDate(), 
											 resultSet.getInt("order_no"));
		} catch(SQLException e) {
			
		}
		
		
		return currentSaleOrder;
	}

	@Override
	public void insertSaleOrder(SaleOrder saleOrder) {
		
		try {
			insertSaleOrder.setInt(1, saleOrder.getOrderNo());
			insertSaleOrder.setDate(2, Date.valueOf(saleOrder.getPurchaseDate()));
			insertSaleOrder.setDate(3, Date.valueOf(saleOrder.getDeliveryDate()));
			insertSaleOrder.setBoolean(4, saleOrder.isRent());
			insertSaleOrder.setString(5, saleOrder.getCustomer().getPhoneNo());
			insertSaleOrder.setString(6, saleOrder.getEmployee().getEmployeeID());
			ResultSet resultSet = insertSaleOrder.executeQuery();
		} catch (SQLException e) {
			
		}
		
		try {
			insertSaleOrder.executeUpdate();
		} catch (SQLException e) {
			
		}
		
		
	}

}

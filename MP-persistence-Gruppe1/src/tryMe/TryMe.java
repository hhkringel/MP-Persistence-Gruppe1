package tryMe;

import java.sql.Connection;
import java.time.LocalDate;

import controller.SaleOrderController;
import controller.SaleOrderControllerIF;
import controller.CustomerController;
import controller.CustomerControllerIF;
import controller.ProductController;
import controller.ProductControllerIF;
import db.DBConnection;
import model.Address;
import model.SaleOrder;

public class TryMe {
	private static SaleOrderControllerIF saleOrderController;
	private static CustomerControllerIF customerController;
	private static ProductControllerIF productController;
	
	
	public static void main(String[]args) {
		init();
		
//		Connection con = DBConnection.getInstance().getDBcon();
//		if(con == null) {
//			System.out.println("fail");
//		}
		
//		Address address = new Address("testStreet", 909090, "testCity", "testCountry");
		
//		saleOrderController.createSaleOrder(LocalDate.EPOCH);
//		System.out.println(saleOrderController.getCurrentSaleOrder().getCustomer());
//		saleOrderController.newPrivateCustomer("John Efternavn", "phone", "email", address);
//		System.out.println(saleOrderController.getCurrentSaleOrder().getCustomer().getName());
		
		String name = productController.findProductByBarcode("1234567890123").getName();
		
		System.out.println(name);
		
		
	}
	
	
	public static void init() {
		saleOrderController = new SaleOrderController();
		customerController = new CustomerController();
		productController = new ProductController();
	}
	
	

}

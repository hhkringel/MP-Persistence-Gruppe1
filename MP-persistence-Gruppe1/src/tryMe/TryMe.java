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
import db.SaleOrderDB;
import db.SaleOrderDBIF;
import model.Address;
import model.SaleOrder;
import model.Customer;

public class TryMe {
	private static SaleOrderControllerIF saleOrderController;
	private static CustomerControllerIF customerController;
	private static ProductControllerIF productController;
	private static SaleOrderDBIF saleOrderDB;
	
	
	public static void main(String[]args) {
		init();
		
		Connection con = DBConnection.getInstance().getDBcon();
		if(con == null) {
			System.out.println("fail");
		}
		
//		Address address = new Address("testStreet", 909090, "testCity", "testCountry");
//		
////		saleOrderController.createSaleOrder(LocalDate.EPOCH);
////		System.out.println(saleOrderController.getCurrentSaleOrder().getCustomer());
//		
//
//		String name = productController.findProductByBarcode("1234567890123").getName();
//		
//		System.out.println(name);
//		
//		Customer customer = customerController.createPrivateCustomer("John Efternavn", "phone5", "email@email.com", address);
////		System.out.println(saleOrderController.getCurrentSaleOrder().getCustomer().getName());
//		System.out.println(customer.getPhoneNo());
		
		
		
		
//		Address address1 = new Address("finalStreet", 123321, "finalCity", "finalCountry");
//		saleOrderController.createSaleOrder(LocalDate.now());
//		saleOrderController.addOrderLineToSaleOrder("1234567890123", 3);
//		saleOrderController.addOrderLineToSaleOrder("1234567890123", 4);
//		saleOrderController.addOrderLineToSaleOrder("1234567890123", 8);
//		saleOrderController.newPrivateCustomer("Final Fuckingtest", "finalPhone", "final@email.com", address1);
//		
//		saleOrderController.newInvoice();
//		
//		saleOrderController.insertSaleOrder();
//		
		
		SaleOrder saleOrder = saleOrderDB.findSaleOrderByID(4);
		System.out.println(saleOrder.getOrderNo());
		
		
	}
	
	
	public static void init() {
		saleOrderController = new SaleOrderController();
		customerController = new CustomerController();
		productController = new ProductController();
		saleOrderDB = new SaleOrderDB();
	}
	
	

}

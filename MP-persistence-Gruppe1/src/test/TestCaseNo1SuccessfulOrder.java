package test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.foreign.AddressLayout;
import java.security.PrivateKey;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.CustomerController;
import controller.ProductController;
import controller.SaleOrderController;
import controller.SaleOrderControllerIF;
import model.Address;
import model.OrderLine;
import model.PrivateCustomer;
import model.SaleOrder;

class TestCaseNo1SuccessfulOrder {

	static SaleOrderController saleOrderController;
	static CustomerController customerController;
	static ProductController productController;
	static OrderLine orderline;
	
	
	@BeforeEach
	public static void setUp() {
		saleOrderController = new SaleOrderController();
		customerController = new CustomerController();
		productController = new ProductController();
				
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void shouldGiveSuccessfulOrder() {
		
		// Arrange
		Address testAddress = new Address("Havevej", "4000", "Vejby", "Rusland");
		PrivateCustomer testCustomer = customerController.createPrivateCustomer("Jens Vejmand", "88888888", "givmigpenge@ofir.dk", testAddress);
		
		SaleOrder testSaleOrder = saleOrderController.addCustomerToOrder(testCustomer);
		
		Product testProduct = productController.findByBarcode("ved ikke hvad en gyldig stregkode");
		
		OrderLine testOrderLine = new OrderLine(5, testProduct);
				
		// Act
		saleOrderController.addOrderLineToSaleOrder(testOrderLine);
		
		
		// Assert
		assertEquals(testCustomer, testSaleOrder.getCustomer(), "Should be the same customer");
		assertEquals(testProduct, testOrderLine.getProduct(), "Should be the same product");
		
		fail("Not yet implemented");
	}

}

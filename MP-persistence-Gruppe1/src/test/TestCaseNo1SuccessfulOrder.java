package test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.foreign.AddressLayout;
import java.security.PrivateKey;
import java.time.LocalDate;

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
import model.Product;
import model.SaleOrder;

class TestCaseNo1SuccessfulOrder {

	static SaleOrderController saleOrderController;
	static CustomerController customerController;
	static ProductController productController;
	static OrderLine orderline;
	
	
	@BeforeEach
	public void setUp() {
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
		saleOrderController.createSaleOrder(LocalDate.EPOCH);
		Address testAddress = new Address("Havevej", 4000, "Vejby", "Rusland");
		PrivateCustomer testCustomer = customerController.createPrivateCustomer("Jens Vejmand", "999999", "givmigpenge@ofir.dk", testAddress);
		
		saleOrderController.addCustomerToSaleOrder(testCustomer);
		
		Product testProduct = productController.findProductByBarcode("123456890123");
		
		OrderLine testOrderLine = new OrderLine(5, testProduct);
				
		// Act
		saleOrderController.addOrderLineToSaleOrder("123456890123", 5);
		
		// Assert
		assertEquals(testCustomer, saleOrderController.getCurrentSaleOrder().getCustomer(), "Should be the same customer");
		assertEquals(testProduct, testOrderLine.getProduct(), "Should be the same product");
		
	}

}

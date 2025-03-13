package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.CustomerController;
import controller.ProductController;
import controller.SaleOrderController;
import model.Address;
import model.OrderLine;
import model.PrivateCustomer;
import model.Product;
import model.SaleOrder;

class TestCaseNo3ErrorInProductOrder {

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
	public void shouldGiveErrorOnProductOnOrder() {
		
		// Arrange
		Address testAddress = new Address("Havevej", 4000, "Vejby", "Rusland");
		PrivateCustomer testCustomer = customerController.createPrivateCustomer("Jens Vejmand", "", "givmigpenge@ofir.dk", testAddress);
		
		SaleOrder testSaleOrder = saleOrderController.addCustomerToOrder(testCustomer);
		
		Product testProduct = productController.findProductByBarcode("0");
		
		OrderLine testOrderLine = new OrderLine(5, testProduct);
				
		// Act
		saleOrderController.addOrderLineToSaleOrder(testOrderLine);
		
		// Assert
		assertEquals(testCustomer, testSaleOrder.getCustomer(), "Should be the same customer");
		assertNull(testOrderLine.getProduct(), "Should be null");
	}

}

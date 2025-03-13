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
import model.Product;
import model.SaleOrder;

class TestCaseNo4ErrorInCustomerOrder {

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
			assertNull(testCustomer.getName(), "Should be null");
			assertEquals(testProduct, testOrderLine.getProduct(), "Should be the same product");
			
		}

}

package controller;

import java.time.LocalDate;

import db.SaleOrderDB;
import db.SaleOrderDBIF;
import model.OrderLine;
import model.Product;
import model.SaleOrder;
import model.Address;
import model.Customer;

public class SaleOrderController implements SaleOrderControllerIF {

	private ProductControllerIF productController;
	private CustomerControllerIF customerController;
	private SaleOrderDBIF saleOrderDB;
	private SaleOrder currentSaleOrder;
	
	public SaleOrderController() {
		
		productController = new ProductController();
		customerController = new CustomerController();
		saleOrderDB = new SaleOrderDB();
		
	}
	
	@Override
	public SaleOrder findSaleOrderByID(int orderNo) {
		return saleOrderDB.findSaleOrderByID(orderNo);
	}


	@Override
	public void insertSaleOrder() {
		
		saleOrderDB.insertSaleOrder(currentSaleOrder);
	}
	
	@Override
	public SaleOrder createSaleOrder(LocalDate purchaseDate) {
		currentSaleOrder = new SaleOrder(purchaseDate);
		
		return currentSaleOrder;
	}

	@Override
	public void newInvoice() {
		
		
	}
	
	public void addOrderLineToSaleOrder(String barcode, int quantity) {
		if (currentSaleOrder == null) {
	        throw new IllegalStateException("No active sale order. Create an order first.");
	    }
		else {
			
			Product foundProduct = productController.findProductByBarcode(barcode);
			OrderLine orderLine = new OrderLine(quantity, foundProduct);
			
			currentSaleOrder.addOrderLine(orderLine);
		}
		
		
		
		
	}
	
	public Customer newPrivateCustomer(String name, String phone, String email, Address address) {
		Customer currentCustomer = customerController.createPrivateCustomer(name, phone, email, address);
		currentSaleOrder.setCustomer(currentCustomer);
		return currentCustomer;
	}
	
	public SaleOrder getCurrentSaleOrder() {
		return currentSaleOrder;
	}


	

}

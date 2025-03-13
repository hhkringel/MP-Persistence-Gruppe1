package controller;

import java.time.LocalDate;

import model.Address;
import model.SaleOrder;

public interface SaleOrderControllerIF {
	SaleOrder findSaleOrderByID(int orderNo);
	void insertSaleOrder();
	SaleOrder createSaleOrder(LocalDate purchaseDate);
	void newInvoice();
	void addOrderLineToSaleOrder(String barcode, int quantity);
	void newPrivateCustomer(String name, String phone, String email, Address address);
	SaleOrder getCurrentSaleOrder();
}

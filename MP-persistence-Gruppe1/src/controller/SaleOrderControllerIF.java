package controller;

import java.time.LocalDate;

import model.SaleOrder;

public interface SaleOrderControllerIF {
	SaleOrder findSaleOrderByID(int orderNo);
	void insertSaleOrder();
	SaleOrder createSaleOrder(LocalDate purchaseDate);
	void newInvoice();

}

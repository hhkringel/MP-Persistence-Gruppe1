package db;

import model.Product;
import model.SaleOrder;

public interface SaleOrderDBIF {
	
	SaleOrder findSaleOrderByID(int orderNo);
	//void updateSaleOrder(); //What to update?
	void insertSaleOrder(SaleOrder saleOrder);

}

package db;

import model.Product;

public interface ProductDBIF {
	
	public Product findProductByBarcode(String barcode);
	
	public void updateProduct(Product product);
	
	public void insertProduct(Product product);
}

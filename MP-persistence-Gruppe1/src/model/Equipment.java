package model;

public class Equipment extends Product {
	
	private Product product;
	
	
	
	
	
	
	
	
	
	
public Equipment(String name, double purchasePrice,
		double salesPrice, double rentPrice,
		String countryOfOrigin, int minStock, String barCode) {
	
		super(name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, barCode);
	
}










public Product getProduct() {
	return product;
}










public void setProduct(Product product) {
	this.product = product;
}
	
	
}

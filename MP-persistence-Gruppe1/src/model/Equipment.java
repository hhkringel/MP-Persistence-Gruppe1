package model;

public class Equipment extends Product {
	
	private Product product;
	private String type;
	private String description;
	
	
	
	
	
	
	
	
	
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


public String getType() {
	return type;
}


public void setType(String type) {
	this.type = type;
}


public String getDescription() {
	return description;
}


public void setDescription(String newDescription) {
	this.description = newDescription;
}
}

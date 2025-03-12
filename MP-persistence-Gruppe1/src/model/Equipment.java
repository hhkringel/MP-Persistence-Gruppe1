package model;

public class Equipment extends Product {
	
	private String type;
	private String description;
		
	public Equipment(String name, double purchasePrice,
					double salesPrice, double rentPrice,
					String countryOfOrigin, int minStock, String barCode) {
	
		super(name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, barCode);
}


public String getType() {
	return type;
}


public void setType(String newType) {
	this.type = newType;
}


public String getDescription() {
	return description;
}


public void setDescription(String newDescription) {
	this.description = newDescription;
}
}

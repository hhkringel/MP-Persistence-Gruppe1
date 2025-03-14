package model;

public class Equipment extends Product {

	private String type;
	private String description;
	
	public Equipment(String name, double purchasePrice, double rentPrice, String countryOfOrigin, int minStock, String barcode, Supplier supplier, String type, String description) {
		super(name, purchasePrice, rentPrice, countryOfOrigin, minStock, barcode, supplier);
		this.type = type;
		this.description = description;
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

	public void setDescription(String description) {
		this.description = description;
	}
	
}

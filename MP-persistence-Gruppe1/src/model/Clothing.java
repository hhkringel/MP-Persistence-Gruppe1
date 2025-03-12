package model;

public class Clothing extends Product {

	private String size;
	private String color;
	
	public Clothing(String name, double purchasePrice, double rentPrice, String countryOfOrigin, int minStock, String barcode, String size, String color) {
		super(name, purchasePrice, rentPrice, countryOfOrigin, minStock, barcode);
		this.size = size;
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}

package model;

public class Clothing extends Product {
	
	private String size;
	private String colour;


public Clothing(String name, double purchasePrice,
		double salesPrice, double rentPrice,
		String countryOfOrigin, int minStock, String barCode, String colour, String size) {
	
	super(name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, barCode);
	this.size = size;
	this.colour = colour;
}
	public String getSize() { 
	return size; 
}
	public void setSize(String newSize) {
	this.size = newSize; 
	}

	public String getColour() {
	return colour; 
	}
	public void setColour(String newColour) {
	this.colour = newColour; 
	}
}
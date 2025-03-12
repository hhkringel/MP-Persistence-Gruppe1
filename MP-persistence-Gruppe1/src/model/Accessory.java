package model;

public class Accessory extends Product {
    private String type;
    private String description;

    public Accessory(String name, double purchasePrice, double salesPrice, double rentPrice, 
                     String countryOfOrigin, int minStock, String barCode, 
                     String type, String description) {
        super(name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, barCode);
        this.type = type;
        this.description = description;
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
    
    public void setDescription(String description) {
    	this.description = description; 
    }
}
package model;

public class OrderLine {

	private int quantity;
	private double soldAtPrice;
	private Product product;
	
	public OrderLine(int quantity, double soldAtPrice, Product product) {
		
		this.quantity = quantity;
		this.soldAtPrice = soldAtPrice;
		this.product = product;
		
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSoldAtPrice() {
		return soldAtPrice;
	}

	public void setSoldAtPrice(double soldAtPrice) {
		this.soldAtPrice = soldAtPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}

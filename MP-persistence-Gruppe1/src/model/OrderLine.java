package model;

public class OrderLine {
	
	private int orderLineID;
	private int quantity;
	private double soldAtPrice;
	private Product product;
	
	public OrderLine(int quantity, Product product) {
		
		this.quantity = quantity;
		this.product = product;
		
	}

	public int getQuantity() {
		return quantity;
	}

	public void addQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSoldAtPrice() {
		return soldAtPrice;
	}

	public void addSoldAtPrice(double soldAtPrice) {
		this.soldAtPrice = soldAtPrice;
	}

	public Product getProduct() {
		return product;
	}
	
	public int getOrderLineID() {
		return orderLineID;
	}

	public void setOrderLineID(int orderLineID) {
		this.orderLineID = orderLineID;
	}
	
	public void setSoldAtPrice() {
		soldAtPrice = getProduct().getPurchasePrice() * quantity;
	}

	
}

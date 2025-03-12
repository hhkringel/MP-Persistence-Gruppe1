package model;

public class OrderLine {
	
	private int orderLineID;
	private int quantity;
	private double soldAtPrice;
	private Product product;
	
	public OrderLine() {
		
		this.quantity = quantity;
		this.soldAtPrice = soldAtPrice;
		this.product = product;
		
	}
	
	public void addProductToOrderLine(Product product) {
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

	
}

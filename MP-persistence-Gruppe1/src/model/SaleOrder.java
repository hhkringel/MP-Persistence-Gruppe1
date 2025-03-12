package model;

import java.time.LocalDate;

public class SaleOrder {

	private LocalDate purchaseDate;
	private LocalDate deliveryDate;
	private String orderNo;
	private boolean isRent;
	private Employee employee;
	
	public SaleOrder(LocalDate purchaseDate, String orderNo) {
		this.purchaseDate = purchaseDate;
		this.deliveryDate = deliveryDate;
		this.orderNo = orderNo;
		this.isRent = isRent;
		this.employee = employee;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public boolean isRent() {
		return isRent;
	}

	public void setRent(boolean isRent) {
		this.isRent = isRent;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}

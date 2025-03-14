package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SaleOrder {

	private LocalDate purchaseDate;
	private LocalDate deliveryDate;
	private int orderNo;
	private boolean isRent;
	private Customer customer;
	private Employee employee;
	private List<OrderLine> orderLines;
	
	public SaleOrder(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
		this.orderLines = new ArrayList<>();
		this.isRent = false;
		this.deliveryDate = null;
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

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
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

	public Customer getCustomer() {
		return customer;
	}

	public void addCustomerToSaleOrder(Customer customer) {
		this.customer = customer;
	}
	
	public void addOrderLineToSaleOrder(OrderLine orderLine) {
		orderLines.add(orderLine);
	}
	
	public List<OrderLine> getOrderLines(){
		return orderLines;
	}
	
}

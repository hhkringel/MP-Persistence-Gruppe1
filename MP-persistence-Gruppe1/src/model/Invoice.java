package model;

import java.time.LocalDate;

public class Invoice {
	private int invoiceNo;
	private LocalDate paymentDate;
	private double totalPrice;
	private SaleOrder saleOrder;
	
	public Invoice(int invoiceNo, LocalDate paymentDate, double totalPrice, SaleOrder saleOrder) {
		this.invoiceNo = invoiceNo;
		this.paymentDate = paymentDate;
		this.totalPrice = totalPrice;
		this.saleOrder = saleOrder;
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public SaleOrder getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}
	
	

}

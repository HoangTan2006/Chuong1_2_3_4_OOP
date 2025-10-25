package iuh.fit.oop.bai2;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class Order {
	private int orderId;
	private Date orderDate;
	private OrderDetail[] orderDetails;
	private int quantityOrderDetail;
	
	public Order(int orderId, Date orderDate) {
		setOrderId(orderId);
		setOrderDate(orderDate);
		
		this.orderDetails = new OrderDetail[5];
		this.quantityOrderDetail = 0;
	}

	public void setOrderId(int orderId) {
		if (orderId < 0) {
			throw new IllegalArgumentException("Order id khong hop le");
		}
		this.orderId = orderId;
	}
	
	public void setOrderDate(Date orderDate) {
		if (orderDate.after(new Date())) {
			throw new IllegalArgumentException("Ngay order khong hop le");
		}
		this.orderDate = orderDate;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	public void addLineItem(Product product, int quantity) {
		if (product == null || quantity <= 0) {
			throw new IllegalArgumentException("So luong phai lon hon 0, san pham khong duoc null");
		}
		
		if (quantityOrderDetail == orderDetails.length) {
			this.orderDetails = Arrays.copyOf(orderDetails, quantity * 2);
		}
		
		for (int i = 0; i < quantityOrderDetail; i++) {
			if (orderDetails[i].getProduct().equals(product)) {
				throw new IllegalArgumentException("Product id da ton tai");
			}
		}
		
		orderDetails[quantityOrderDetail++] = new OrderDetail(this, product, quantity);
	}
	
	public double calcTotalCharge() {
		double total = 0.0;
		for (int i = 0; i < quantityOrderDetail; i++) {
			total += orderDetails[i].calcTotalPrice();
		}
		return total;
	}
	
	@Override
	public String toString() {
		StringBuilder dataOrderDetails = new StringBuilder();
		DateFormat df = DateFormat.getDateInstance();
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
		
		String ln = System.lineSeparator();
		
		dataOrderDetails
			.append("Ma HD: ").append(orderId).append(ln)
			.append("Ngay lap HD: ").append(df.format(orderDate)).append(ln)
			.append(String.format(
				    "%-4s | %-10s | %-30s | %15s | %10s | %15s%n",
				    "STT", "Ma SP", "Mo ta", "Don gia", "So Luong", "Thanh tien"
				));
		
		for (int i = 0; i < quantityOrderDetail; i++) {
			dataOrderDetails.append(String.format("%-4d | %s", i + 1, orderDetails[i].toString()))
			.append(System.lineSeparator());
		}
		dataOrderDetails.append("Tong tien thanh toan: ").append(nf.format(calcTotalCharge()));
		return dataOrderDetails.toString();
	}
}

package iuh.fit.oop.bai2;

import java.text.NumberFormat;
import java.util.Locale;

public class OrderDetail {
	private Order order;
	private Product product;
	private int quantity;
	
	public OrderDetail(Order order, Product product, int quantity) {
		setOrder(order);
		setProduct(product);
		setQuantity(quantity);
	}

	public void setOrder(Order order) {
		if (order == null) {
			throw new IllegalArgumentException("Order khong hop le");
		}
		this.order = order;
	}
	
	public void setProduct(Product product) {
		if (order == null) {
			throw new IllegalArgumentException("Order khong hop le");
		}
		this.product = product;
	}
	
	public void setQuantity(int quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException("So luong phai lon hon 0");
		}
		this.quantity = quantity;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double calcTotalPrice() {
		return quantity * product.getPrice();
	}
	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
		return String.format("%54s | %10s | %15s", 
				product.toString(),
				quantity,
				nf.format(calcTotalPrice()));
	}
}

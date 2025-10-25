package iuh.fit.oop.bai2;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public class Product {
	private String ProductId;
	private String description;
	private double price;
	
	public Product() {
		ProductId = "000000";
		this.description = "null";
		this.price = 0.0;
	}

	public Product(String productId, String description, double price) {
		setProductId(productId);
		setDescription(description);
		setPrice(price);
	}

	public String getProductId() {
		return ProductId;
	}

	public void setProductId(String productId) {
		if (productId == null || productId.isBlank() || productId.contains(" ")) {
			throw new IllegalArgumentException("Ma san pham duoc chua khoang trang");
		}
		ProductId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description == null || description.isBlank()) {
			throw new IllegalArgumentException("Mo ta khong duoc de trong");
		}
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price <= 0) {
			throw new IllegalArgumentException("Gia phai lon hon 0");
		}
		this.price = price;
	}
	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
		return String.format("%-10s | %-30s | %15s", 
				ProductId, 
				description, 
				nf.format(price));
	}

	@Override
	public int hashCode() {
		return Objects.hash(ProductId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(ProductId, other.ProductId);
	}
}

package iuh.fit.oop.bai2;

import java.util.Date;

public class Test {
	public static void main(String[] args) {
		Product product1 = new Product("product1", "Wireless Mouse", 299000.00);
		Product product2 = new Product("product2", "Mechanical Keyboard", 790000.50);
		Product product3 = new Product("product3", "USB-C Hub", 340000.25);
		Product product4 = new Product("product4", "27-inch Monitor", 1890000.99);
		Product product5 = new Product("product5", "Laptop Stand", 42000000.00);
		
		Order order1 = new Order(1, new Date());
		Order order2 = new Order(2, new Date());
		
		order1.addLineItem(product1, 5);
		order1.addLineItem(product3, 2);
		order1.addLineItem(product4, 7);
		
		order2.addLineItem(product2, 3);
		order2.addLineItem(product4, 2);
		
		System.out.println(order1);
		System.out.println(order2);
	}
}

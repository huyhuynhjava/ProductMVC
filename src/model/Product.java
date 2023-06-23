package model;

import java.util.Objects;
import java.util.Scanner;

public  class Product implements Comparable<Product> {
	protected String id;
	protected int price;
	
	public Product() {}
	
	public Product(String id, int price) {
		this.id = id;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String name) {
		this.id = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [ID=" + id + ", price=" + price + " " ;
	}
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id :");
		this.id  = sc.nextLine();
		System.out.println("enter price :");
		this.price = Integer.parseInt(sc.nextLine());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, price);
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
		return Objects.equals(id, other.id) && price == other.price;
	}

	@Override
	public int compareTo(Product o) {
		return this.price - o.price;
	}
	


	
	
	
}

package model;

import java.util.Objects;
import java.util.Scanner;

public class Software extends Product {
	private String name;
	public Software(String id, int price, String name) {
		super(id, price);
		this.name = name;
	}
	public Software() {}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void input() {
		super.input(); 
		System.out.println("enter name");
		Scanner sc = new Scanner(System.in);
		this.name = sc.nextLine();
	}
	@Override
	public String toString() {
		return super.toString() + " name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(name);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Software other = (Software) obj;
		return super.equals(obj) && Objects.equals(name, other.name);
	}
	
	
		
}

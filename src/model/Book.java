package model;

import java.util.Objects;
import java.util.Scanner;

public class Book extends Product {
	   private String title;
	   private String author;
	   
	public Book(String id, int price, String title, String author) {
		super(id, price);
		this.title = title;
		this.author = author;
	}
	
	public Book() {}
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return super.toString() +" Title=" + title + " Author=" + author + "]";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(author, title);
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
		Book other = (Book) obj;
		return super.equals(obj) && Objects.equals(author, other.author) && Objects.equals(title, other.title);
	}

	public void input() {
		super.input();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter title :");
		this.title  = sc.nextLine();
		System.out.println("enter author :");
		this.author = sc.nextLine();
	}
	
	   
}

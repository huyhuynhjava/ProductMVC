package controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import dao.daoImplement;
import model.Book;
import model.Product;
import model.Software;

public class ControllerProduct {
	private ArrayList<Product> list;
	private daoImplement dao;

	public ControllerProduct() {
		this.dao = new daoImplement();
		list = new ArrayList<Product>();
	}

	public void addProduct(int n) {
		Product a = null;
		if (n == 1) {
			a = new Book();
			a.input();

		} else {
			a = new Software();
			a.input();
		}
		dao.addProduct(a);
		list.add(a);
	}

	public void getProduct(String id) {
		if (dao.getProduct(id) != null) {
			System.out.println(dao.getProduct(id));
		} else
			System.out.println("Invalid id");
	}

	public void updateProduct(String id) {
		dao.updateProduct(list, id);
	}

	public void deleteProduct(String id) {
		dao.deleteProduct(id);
		for (Product p : list) {
			if (p.getId().equals(id))
				list.remove(p);
		}

	}

	public void getAllFromFile() throws FileNotFoundException {
		this.list = (ArrayList<Product>) dao.getAllProduct();
	}

	public void listAllProduct() throws FileNotFoundException {
		for (Product p : list) {
			System.out.println(p);
		}
	}
	public void sort() throws FileNotFoundException {
		Collections.sort(list);
		dao.saveToFile(list);
	}

}

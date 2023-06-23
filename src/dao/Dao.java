package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import model.Product;

public interface Dao {
	void addProduct(Product p);
	void updateProduct(List<Product> p, String id);
	void deleteProduct(String id);
	Product getProduct(String id);
	List<Product> getAllProduct()throws FileNotFoundException;
	
}

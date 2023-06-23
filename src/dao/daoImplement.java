package dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Book;
import model.Product;
import model.Software;

public class daoImplement implements Dao {
	private static final String FILE_PATH = "D:\\FileObject\\product.txt";
	
	
	//Create
	@Override
	public void addProduct(Product p ) {
		FileWriter stream=null;
		try {
			stream = new FileWriter(FILE_PATH,true);
			PrintWriter writer = new PrintWriter(stream );
			writer.print(getData(p));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	public String getData(Product p) {
		if(p instanceof Book) {
			return "1 "+ ((Book)p).getId() +  " " + ((Book)p).getPrice() + " " +((Book)p).getTitle() + " " + ((Book)p).getAuthor()+"\n"; 
		}else {
			return "2 "+ ((Software)p).getId() +  " " + ((Software)p).getPrice() + " " + ((Software)p).getName() + "\n";
		}
	}

	//update
	@Override
	public void updateProduct(List<Product> p, String id) {;
		try {
			p = getAllProduct();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		boolean check = true;
		for(Product a : p) {
			if(a.getId().equals(id)) {
				a.input();
				check = false;
				break;
			}
		}
		if(check) System.out.println("ID invalid");
		try {
			saveToFile(p);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}
	public void saveToFile(List<Product> p) throws FileNotFoundException {
		PrintWriter printer = new PrintWriter(FILE_PATH) ;
		for(int i = 0; i< p.size(); i++) {
			printer.write(getData(p.get(i)));
		}
		printer.close();
	}

	public List<Product> getAllProduct() throws FileNotFoundException {
			List<Product> p = new ArrayList<Product>();
			FileReader file = new FileReader(FILE_PATH);
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				String[] se = sc.nextLine().split(" ");
				Product a;
					if(se[0].equals("1")) {	
						a = new Book(se[1], Integer.parseInt(se[2]), se[3],se[4]);
						
					}else {
						 a = new Software(se[1], Integer.parseInt(se[2]), se[3]);
					}
					if(!p.contains(a)) p.add(a);
			}
			return p;
			
	}
	
	
	//delete
	@Override
	public void deleteProduct(String id) {
		List<Product>  p = new ArrayList<Product>();
		try {
			p = getAllProduct();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		boolean check = true;
		for(Product a : p) {
			if(a.getId().equals(id)) {
				p.remove(a);
				check = false;
				break;
			}
		}
		if(check) System.out.println("ID invalid");
		try {
			saveToFile(p);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		
	}
	// Read
	@Override
	public Product getProduct(String id) {
		List<Product>  p = new ArrayList<Product>();
		try {
			p = getAllProduct();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		boolean check = false;
		for(Product a : p) {
			if(a.getId().equals(id)) {
				return a;
		}
		
	}
		return null;

	
}
}

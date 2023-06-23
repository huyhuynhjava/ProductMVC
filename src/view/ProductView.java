package view;

import java.io.FileNotFoundException;
import java.util.Scanner;

import controller.ControllerProduct;
import model.Product;

public class ProductView {
	private ControllerProduct control;

	public ProductView() {
		this.control = new ControllerProduct();

	}

	public void showView() throws FileNotFoundException {
		int n = 0;
		do {
			System.out.println("1. Add an product");
			System.out.println("2. get product by id");
			System.out.println("3. update product by id");
			System.out.println("4. delete product ");
			System.out.println("5. list product ");
			System.out.println("6. get all from file ");
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			sc.nextLine();
			switch (n) {
			case 1: {
				System.out.println("1. Add book");
				System.out.println("2. Add software");
				int choice = sc.nextInt();
				control.addProduct(choice);
				break;
			}
			case 2: {
				System.out.println("enter id of product want to get");
				String id = sc.nextLine();
				control.getProduct(id);
				break;
			}
			case 3: {
				System.out.println("enter id of product want to get");
				String id = sc.nextLine();
				control.updateProduct(id);
				break;
			}
			case 4: {
				System.out.println("enter id of product want to remove");
				String id = sc.nextLine();
				control.deleteProduct(id);
				break;
			}
			case 5: {
				control.listAllProduct();
				break;
			}
			case 6: {
				control.getAllFromFile();
				break;
			}
			case 7: {
				control.sort();
				break;
			}
			}

		} while (n != 0);
	}

	public static void main(String[] args) throws FileNotFoundException {
		ProductView v = new ProductView();
		v.showView();
	}

}

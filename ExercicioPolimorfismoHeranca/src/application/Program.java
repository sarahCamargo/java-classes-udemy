package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Product> list = new ArrayList<>();

		System.out.print("Enter the number of products ");
		int n = sc.nextInt();

		for (int i = 1; i <=n; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.println("Common, used or imported (c/u/i)?");
			char opt = sc.next().charAt(0);
			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Price: ");
			Double price = sc.nextDouble();
			if (opt == 'i') {
				System.out.println("Customs fee: ");
				Double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			} else if (opt == 'u') {
				System.out.println("Manufacture Date: ");
				Date date = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, date));
			} else {
				list.add(new Product(name, price));
			}
		}
		
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}

		sc.close();

	}

}

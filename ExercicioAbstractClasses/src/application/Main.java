package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();
		Double totalTaxes = 0.0;
		System.out.println("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.println("Individual or Company (i/c)?");
			char opt = sc.next().charAt(0);
			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Anual Income: ");
			Double anualIncome = sc.nextDouble();
			
			if (opt == 'i') {
				System.out.println("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			} else if (opt == 'c') {
				System.out.println("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}
		System.out.println("TAXES PAID");
		for (TaxPayer payer : list) {
			totalTaxes += payer.tax();
			System.out.println(payer.getName() + ": $ " + payer.tax());
		}
		System.out.println("TOTAL TAXES: $ " + totalTaxes);
		
		sc.close();

	}

}

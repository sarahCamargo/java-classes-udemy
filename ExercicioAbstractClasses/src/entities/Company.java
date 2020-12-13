package entities;

public class Company extends TaxPayer{

	private int numberOfEmployees;

	public Company(String name, Double anualIncome, int numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}
	
	@Override
	public Double tax() {
		Double taxPercent = 0.16;
		if (numberOfEmployees > 10) {
			taxPercent = 0.14;
		}
		return getAnualIncome() * taxPercent;
	}
	
	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
}

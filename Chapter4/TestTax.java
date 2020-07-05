
public class TestTax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double grossIncome;
		String state;
		int dependents;

		grossIncome = 50000;
		dependents = 2;
		state = "NJ";

		Tax t = new Tax(grossIncome, state, dependents);// Instantiation
		double yourTax = t.calcTax();

		Tax t2 = new Tax(65000, "TX", 4);
		double hisTax = t2.calcTax();

		t.convertToEuros(yourTax);
		t2.convertToEuros(hisTax);
	}

}

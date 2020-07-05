
public class TestTax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 3) {
			System.out.println("Sample usage of the program:" + " java TestTax 50000 NJ 2");
			System.exit(0);
		}
		double grossIncome = Double.parseDouble(args[0]);
		String state = args[1];
		int dependents = Integer.parseInt(args[2]);

		Tax t = new Tax(grossIncome, state, dependents);// Instantiation
		double yourTax = t.calcTax();
		System.out.println("Your tax is" + yourTax);

	}

}

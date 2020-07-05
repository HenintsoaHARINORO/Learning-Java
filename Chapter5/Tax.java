
class Tax {
	double grossIncome;
	String state;
	int dependents;

	// constructor
	Tax(double gi, String st, int depen) {
		// initializing
		grossIncome = gi;
		state = st;
		dependents = depen;
	}

	public double calcTax() {
		double stateTax = 0;
		if (grossIncome < 3000) {
			stateTax = grossIncome * 0.05;
		} else {
			stateTax = grossIncome * 0.06;
		}
		return stateTax;

	}
}

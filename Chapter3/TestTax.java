
class TestTax {
	public static void main(String[] args) {
		/*
		 * Tax t= new Tax(); // creating an instance
		 * 
		 * // assigning the values to class members t.grossIncome= 5000; t.dependents=
		 * 2; t.state= "NJ";
		 * 
		 * double yourTax= t.calcTax(); // calculating tax
		 */

		NJTax t = new NJTax(); // creating a new instance from the subclass
		double yourTax = t.calcTax();
		double totalTax = t.adjustForStudents(yourTax);

		System.out.println(" Your tax is " + yourTax);
		System.out.println(" Your tax total is " + totalTax);
	}
}

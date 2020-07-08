
public class TestStackTrace {
	TestStackTrace() {
		// divideByZero();
	}

	int divideByZero() {
		return 25 / 0;
	}

	void withdrawFunds(double amount) {
		if (amount > 5000) {
			System.out.println("withdrawal successfull : " + amount);
		}
		throw new RuntimeException("You couldn't exceeded the withdrawal limit of 5000");

	}

	public static void main(String[] args) {
		try {
			TestStackTrace test = new TestStackTrace();
			// this will work
			test.withdrawFunds(6000);// it also depends on the order of the instructions in the main
			test.withdrawFunds(2000);
			// this will not work

		} catch (Exception exc) {
			System.out.println("Sorry, we encountered an error");
			System.out.println("Error message: " + exc.getMessage());
		}
	}
}

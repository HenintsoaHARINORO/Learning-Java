
public class Customer extends CommonData {
	private String firstName;
	private String lastName;

	public Customer(String a, String b) {
		this.firstName = a;
		this.lastName = b;
	}

	public void doSomething() {
		System.out.println("Customer " + firstName + " " + lastName + " .In doSomething()");
	}
}

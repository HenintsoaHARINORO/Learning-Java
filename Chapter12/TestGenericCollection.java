import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TestGenericCollection {
	public static void main(String[] args) {
		List<Customer> customers = new ArrayList<>();
		Customer customer1 = new Customer("David", "Lee");
		customers.add(customer1);

		Customer customer2 = new Customer("Cooper", "Jack");
		customers.add(customer2);
		Order order = new Order();

		processData(customers);

	}

	private static void processData(List<Customer> customers) {
		for (Customer c : customers) {
			c.doSomething();

		}
	}
}

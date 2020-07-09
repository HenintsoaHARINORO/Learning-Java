
import java.util.Hashtable;
import java.util.Map;

public class TestHashTable {
	public static void main(String[] args) {
		Customer customer = new Customer("David", "Mary");
		Order order = new Order();
		Portfolio portfolio = new Portfolio();

		Map data = new Hashtable();
		data.put("Customer", customer);
		data.put("Order", order);
		data.put("Portfolio", portfolio);

		Customer myCustomer= (Customer) data.get("Customer");
		
	}
}

import java.util.ArrayList;

public class TestArrayList {
	public static void main(String[] args) {
		ArrayList customers = new ArrayList();
		Customer cust1 = new Customer("David", " Mary");
		customers.add(cust1);
		Customer cust2 = new Customer("John", " Mark");
		customers.add(cust2);
		Order ord = new Order();
		customers.add(ord);

		int totalElement = customers.size();
		System.out.println("Size= " + totalElement);
		
		for(int i=0;i<totalElement;i++) {
			Customer currentCust= (Customer) customers.get(i);
		}
	}
}

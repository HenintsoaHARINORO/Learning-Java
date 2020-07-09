import java.util.*;

public class VariousCollections {
   public static void main(String [] args) {
	   HashSet s= new HashSet();
	   s.add("Henintsoa");
	   s.add("Lily");
	   
	   ArrayList a = new ArrayList();
		
		a.add("Mary");
		a.add("Mary");
		
		Vector bbb = new Vector();
		
		Map hm=new HashMap();
		hm.put("customer", new Customer("John", "Smith")); 
		hm.put("order", new Order());
		
		LinkedList list= new LinkedList();
		list.add("LuLu");
		
		for (Object t: list) {
			System.out.println(t);
		}
   }
}

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ClassBEXt {
	public static void main(String[] args) {
		try (FileInputStream fIn = new FileInputStream("NewEmployee2.ser");
				ObjectInputStream oIn = new ObjectInputStream(fIn);) {
			Employee2 emp = new Employee2();
			emp.readExternal(oIn);
			System.out.println("Deserialized employee with id " + emp.id);
			
			System.out.printf("salary = $%7.2f", emp.salary);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}

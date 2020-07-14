import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ClassA {
	public static void main(String args[]) {
		Employee emp = new Employee();
		emp.lName = "John";
		emp.fName = "Smith";
		emp.salary = 50000;
		try (FileOutputStream fOut = new FileOutputStream("BestEmployee.ser");
				ObjectOutputStream oOut = new ObjectOutputStream(fOut);) {
			oOut.writeObject(emp);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println("Employee object has been serialized into BestEmployee.ser");
	}
}

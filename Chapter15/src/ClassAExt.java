import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class ClassAExt {

	public static void main(String[] args) {
		Employee2 emp = new Employee2();
		emp.fName = "John";
		emp.lName = "Smith";
		emp.salary = 50000;
		emp.address = "12 main street";
		emp.hireDate = new Date();
		emp.id = 123;
		try (FileOutputStream fOut = new FileOutputStream("NewEmployee2.ser");
				ObjectOutputStream oOut = new ObjectOutputStream(fOut);) {
			emp.writeExternal(oOut); 
			System.out.println("An employee is externalized into NewEmployee2.ser");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}

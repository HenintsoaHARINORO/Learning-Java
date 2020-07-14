import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class Employee2 implements java.io.Externalizable {
	String lName;
	String fName;
	String address;
	Date hireDate;
	int id;
	double salary;

	public void writeExternal(ObjectOutput stream) throws java.io.IOException {

		stream.writeDouble(salary);
		stream.writeInt(id);
	}

	public void readExternal(ObjectInput stream) throws java.io.IOException {
		salary = stream.readDouble();

		id = stream.readInt();
	}
}

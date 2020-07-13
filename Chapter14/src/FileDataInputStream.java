import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileDataInputStream {

	

	public static void main(String[] args) {
		try (FileInputStream myFile = new FileInputStream("myData.dat");
				BufferedInputStream buff = new BufferedInputStream(myFile);
				DataInputStream data = new DataInputStream(buff);) {
			int num1 = data.readInt();
			int num2 = data.readInt();
			float num6 = data.readFloat();
			float num3 = data.readFloat();
			float num4 = data.readFloat();
			double num5 = data.readDouble();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}

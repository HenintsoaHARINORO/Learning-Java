import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {
	public static void main(String[] args) {
		int somedata[] = { 56, 230, 123, 43, 11, 37 };
		try (FileOutputStream myFile = new FileOutputStream("xyz.dot");) {
			for (int i = 0; i < somedata.length; i++) {
				
				myFile.write(somedata[i]);
			}
		} catch (IOException ioe) {
			System.out.println("Could not write to a file: " + ioe.toString());
		}
	}
}

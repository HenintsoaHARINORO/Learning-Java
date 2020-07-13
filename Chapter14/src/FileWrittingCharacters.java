import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FileWrittingCharacters {
public static void main(String [] args) {
	try (FileOutputStream myFile = new FileOutputStream("abc.txt");
			Writer out = new BufferedWriter(
			new OutputStreamWriter(myFile, "UTF8"));) {
			String myAddress = "Hello ";
			out.write(myAddress);
			} catch(IOException e){
			e.printStackTrace();
			}
}
}

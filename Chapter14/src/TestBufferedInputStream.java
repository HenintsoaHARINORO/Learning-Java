import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestBufferedInputStream {
	public static void main(String[] args) {
	try(
	FileInputStream myFile = new FileInputStream("def.dot");
	BufferedInputStream buff = new BufferedInputStream(myFile);)
	{
		boolean eof = false;
		while (!eof) {
			int byteValue = buff.read();
			System.out.print(byteValue + " ");
			if (byteValue == -1)
				eof = true;
		}
	}catch(IOException ioe)
	{
			ioe.printStackTrace();
	}
  }
}


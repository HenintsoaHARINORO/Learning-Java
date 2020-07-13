import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WritingInFile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter the text you want to write in the file:");
		try {

			String txt = sc.nextLine();
			File file = new File("input.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter filewrite = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bufferedWrite = new BufferedWriter(filewrite);
			bufferedWrite.write(txt);
			bufferedWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

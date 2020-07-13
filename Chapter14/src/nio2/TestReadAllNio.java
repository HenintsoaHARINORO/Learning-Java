package nio2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestReadAllNio {
	public static void main(String[] args) {
		Path statesFile = Paths.get("states.txt");
		try {

			List<String> states = Files.readAllLines(statesFile, StandardCharsets.UTF_8);

			states.forEach(System.out::println);
		} catch (IOException ioe) {
			System.out.println("Error while reading states.txt: " + ioe.getMessage());
		}
	}
}

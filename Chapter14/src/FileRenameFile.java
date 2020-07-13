import java.io.File;
import java.io.IOException;

public class FileRenameFile {

	public static void main(String[] args) {
		File file = new File("customers.txt");
		File backup = new File("customers.txt.bak");
		
		try {
			if (!file.exists()){
		    
		     file.createNewFile();
			}
			file.renameTo(backup);
			} catch (IOException e) {
				
			
				
				e.printStackTrace();
			}
		}
			
		

	}



package IR.Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DocumentReader {
	
	protected File file;
	
	public DocumentReader(File file) {
		this.file= file;
	}
	
	public ArrayList<String> read() {
		ArrayList<String> lines = new ArrayList<String>();
		try {			
			FileReader reader = new FileReader(this.file);
			BufferedReader buffered = new BufferedReader(reader);
			while(buffered.readLine() != null) {
				lines.add(buffered.readLine());
			}
			buffered.close();
		} catch(FileNotFoundException e) {
			System.out.println("File does not exist");			
		} catch(IOException e) {
			System.out.println("IOError");
		}
		return lines;
	}
}

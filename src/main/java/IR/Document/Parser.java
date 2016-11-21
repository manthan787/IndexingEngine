package IR.Document;

import IR.Reader.DocumentReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Parser {
	
	protected String documentPath;
	
	public Parser(String documentPath) {
		this.documentPath = documentPath;
	}
					
	public Map<String, String> parse(File file) throws FileNotFoundException, IOException {
		ArrayList<String> content = this.readFile(file);		
		Map<String, String> documents = new HashMap<String, String>();
		int i = 0;
		String docNo = "";
		String text = "";	
		System.out.println(content);
		while(i < content.size() - 1) {			
			String line = content.get(i);
			if(line.startsWith("<DOCNO>")) {
				System.out.println("Found at i: " + i);
				docNo = line.split("\\s+")[1];				
			}
			
			if(line.startsWith("<TEXT>")) {
				int intermediate = 1;
				while(!line.startsWith("</TEXT>") && ! line.startsWith("</DOC>")) {
					line = content.get(i + intermediate);
					text += line;
					intermediate++;
				}
				documents.put(docNo, text);
				i += (intermediate - 1);				
				text = "";
				docNo = "";
			}
			i++;
		}			
		return documents;		
	}
	
	public Map<String, String> parseAll() throws FileNotFoundException, IOException {
		Map<String, String> documents = new HashMap<String, String>(); 
		File folder = new File(this.documentPath);
		File[] files = folder.listFiles();
		for(File file : files) {
			Map<String, String> parsedDoc = this.parse(file);
			documents = new HashMap<String, String>(documents);
			documents.putAll(parsedDoc);
		}
		return documents;
	}
	
	protected ArrayList<String> readFile(File file) {
		DocumentReader reader = new DocumentReader(file);		
		ArrayList<String> content = reader.read();		
		return content;
	}
	
	public String extractDocumentId(File file) {
		String[] tokens = file.getName().split("\\.");	
		return tokens[0];
	}
	
	public static void main(String[] args) {		
		Parser p = new Parser(IR.Config.DOCUMENTS_PATH);
		//p.parseAll();
		try {
			File file = new File(IR.Config.DOCUMENTS_PATH + "/" + "ap890101");
			p.parse(file);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

package IR.Document;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;


public class DocumentReader {
	
	/**
	 * This method takes the path of the document json file as a string with the following format:
	 * {"document-id" -> "conent"}
	 * and returns the json file as a Map containing Document ID as key and its content as value.
	 * @param filePath 
	 * @return A key-value pair of Document ID and content
	 * @throws IOException
	 * @throws JSONException
	 */
	public static Map<String, String> read(String filePath) throws IOException, JSONException {		
			try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
				Map<String, String> documents = new HashMap<String, String>();			
				String line = br.readLine();
				StringBuilder jsonData = new StringBuilder();			
				while(line != null) {
					jsonData.append(line);
					line = br.readLine();
				}		
				JSONObject json = new JSONObject(jsonData.toString());
				String[] keys = JSONObject.getNames(json);
				for(String key : keys) {
					documents.put(key, (String) json.get(key)); 
				}			
				return documents;
			}
	}
	
	public static void main(String[] args) {	
		try{
			Map<String, String> Documents = DocumentReader.read("/Users/admin/Documents/Java/Indexer/src/main/resources/docs.json");
			String documentsPath = "/Users/admin/Documents/Java/Indexer/src/main/resources/corpus/";
			System.out.println("Writing documents to file in the location: " + documentsPath);
			for(Map.Entry<String, String> entry : Documents.entrySet()) {				
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(documentsPath + entry.getKey()))) {
					bw.write(entry.getValue());					
				}
			}
		} catch(Exception e) {
			System.out.println("Error!");
		}
	}
	
}

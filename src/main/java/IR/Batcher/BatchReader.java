package IR.Batcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class BatchReader {
	
	public static Map<String, String> readBatch(Batch b) throws FileNotFoundException, IOException {
		Map<String, String> documents = new HashMap<String, String>();
		File[] files = b.getDocuments();
		for(File f : files) {
			String documentID = f.getName();
			StringBuilder content = new StringBuilder();
			try(BufferedReader br = new BufferedReader(new FileReader(IR.Config.CORPUS_PATH + "/" + documentID))) {
				String line = "";
				while((line = br.readLine()) != null) {
					content.append(line);
				}
			}
			documents.put(documentID, content.toString());
		}
		return documents;
	}
		
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Batcher b = new Batcher("/Users/admin/Documents/Java/corpus");
		ArrayList<Batch> batches = b.createBatches();		
		Map<String, String> ans = BatchReader.readBatch(batches.get(0));
		System.out.println(ans.get("AP890102-0002"));
	}
}

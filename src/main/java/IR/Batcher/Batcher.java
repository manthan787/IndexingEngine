package IR.Batcher;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Batcher {
	
	protected String corpusPath;
	protected int batchSize;
	
	public Batcher(String corpusPath) {
		this(corpusPath, 1000);
	}
	
	public Batcher(String corpusPath, int batchSize) {
		this.corpusPath = corpusPath;
		this.batchSize = batchSize;
	}
	
	public ArrayList<Batch> createBatches() {		
		File folder = new File(this.corpusPath);
		File[] files = folder.listFiles();		
		int counter = 0;
		ArrayList<Batch> batches = new ArrayList<Batch>();
		for(int i  = 0; i < files.length - 1; i += this.batchSize) {
			File[] documents = Arrays.copyOfRange(files, i, Math.min(i + this.batchSize, files.length));
			Batch b = new Batch(counter++, documents);
			batches.add(b);			
		}
		return batches;
	}
	
	public static void main(String[] args) {
		Batcher b = new Batcher("/Users/admin/Documents/Java/corpus");
		ArrayList<Batch> batches = b.createBatches();
		for(Batch ba : batches) {
			System.out.println(ba.getBatchID() + " : " + ba.getDocuments().length);
		}
	}
}

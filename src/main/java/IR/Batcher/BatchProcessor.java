package IR.Batcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import IR.Catalog.Catalog;
import IR.Indexer.BatchIndexer;

public class BatchProcessor {
	
	protected String batchPath;
	
	public BatchProcessor(String batchPath) {
		this.batchPath = batchPath;
	}
	
	public void process() throws FileNotFoundException, IOException {
		Batcher batcher = new Batcher(this.batchPath);
		ArrayList<Batch> batches = batcher.createBatches();
		for(Batch b : batches) {
			this.processSingleBatch(b);
		}
	}
	
	protected void processSingleBatch(Batch b) throws FileNotFoundException, IOException {
		Map<String, String> documents = BatchReader.readBatch(b);
		Catalog catalog = new Catalog(b.getBatchID());
		BatchIndexer batchIndexer = new BatchIndexer(documents, catalog);
	}
}

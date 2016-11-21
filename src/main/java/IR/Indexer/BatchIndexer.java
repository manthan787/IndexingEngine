package IR.Indexer;

import java.util.Map;

import IR.Catalog.Catalog;

public class BatchIndexer {
	
	protected Map<String, String> documents;
	protected Catalog catalog;
	
	public BatchIndexer(Map<String, String> documents, Catalog catalog) {
		this.documents = documents;
		this.catalog = catalog;
	}
	
	public void index() {
		
	}
}

package IR.Indexer;

import java.util.Map;

import IR.Catalog.Catalog;

/**
 * Service class to Index one single batch 
 * @author Manthan
 *
 */
public class BatchIndexer {
	
	protected Map<String, String> documents;
	protected Catalog catalog;
	
	/**
	 * Instantiate the object with read documents, and the catalog for the 
	 * batch to be indexed
	 * @param documents
	 * @param catalog
	 */
	public BatchIndexer(Map<String, String> documents, Catalog catalog) {
		this.documents = documents;
		this.catalog = catalog;
	}
	
	
	/**
	 * 
	 */
	public void index() {
		
	}
}

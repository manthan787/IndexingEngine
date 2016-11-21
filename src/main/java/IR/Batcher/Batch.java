package IR.Batcher;

import java.io.File;

public class Batch {
	protected int batchID;
	protected File[] documents;
	
	public Batch(int batchID, File[] documents) {
		this.batchID = batchID;
		this.documents = documents;
	}
	
	public int getBatchID() {
		return batchID;
	}

	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}

	public File[] getDocuments() {
		return documents;
	}

	public void setDocuments(File[] documents) {
		this.documents = documents;
	}		
}

package IR.Catalog;


public class Catalog {
	protected int batchID;
	protected int[] catalogOffsets;
	
	
	public Catalog(int batchID) {
		this.batchID = batchID;	
	}


	public int getBatchID() {
		return batchID;
	}


	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}


	public int[] getCatalogOffsets() {
		return catalogOffsets;
	}


	public void setCatalogOffsets(int[] catalogOffsets) {
		this.catalogOffsets = catalogOffsets;
	}
	
	
	
}

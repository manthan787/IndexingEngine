package IR.Indexer.Mapper;

import IR.Config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Mapper implements Serializable {
	protected static int prevDocID = 0;
	protected static int prevTokenID = 0;
	
	
	protected Map<String, Integer> tokenMap;
	protected Map<String, Integer> docIdMap;
	protected Map<Integer, String> docIdReverseMap;
	
	
	public Mapper() {
		this.tokenMap = new HashMap<String, Integer>();
		this.docIdMap = new HashMap<String, Integer>();
		this.docIdReverseMap = new HashMap<Integer, String>();
	}
		
	
	public Mapper(Map<String, Integer> tokenMap, Map<String, Integer> docIdMap, Map<Integer, String>docIdReverseMap) {
		this.tokenMap = tokenMap;
		this.docIdMap = docIdMap;
		this.docIdReverseMap = docIdReverseMap;
	}
		
	
	public int mapToken(String token) {
		if(this.tokenMap.containsKey(token)) {
			return this.tokenMap.get(token);
		} else {
			this.prevTokenID++;
			this.tokenMap.put(token, this.prevTokenID);
			return this.prevTokenID;
		}
	}
	
	public int mapDocId(String docName) {
		if(this.docIdMap.containsKey(docName)) {
			return this.docIdMap.get(docName);
		} else {
			this.prevDocID++;
			this.tokenMap.put(docName, this.prevDocID);
			return this.prevDocID;
		}
	}
	
	public int lookupToken(String token) throws KeyNotFoundException{
		if(this.tokenMap.containsKey(token)) {
			return this.tokenMap.get(token);
		} 
		throw new KeyNotFoundException("The key does not exist in the Token Map");
	}
	
	public int lookupDocId(String docId) throws KeyNotFoundException{
		if(this.docIdMap.containsKey(docId)) {
			return this.docIdMap.get(docId);
		}
		
		throw new KeyNotFoundException("The key does not exist in the DocID Map");		
	}
	
	public int reverseLookupDocId(int mapped_docId) throws KeyNotFoundException{
		if(this.docIdReverseMap.containsKey(mapped_docId)) {
			return this.docIdMap.get(mapped_docId);
		}
		
		throw new KeyNotFoundException("The key does not exist in the Reverse DocID Map");		
	}

	public static void main(String[] args) {
		Mapper m = new Mapper();
		m.mapToken("hey");
		m.mapToken("what");
		try {
			System.out.println(m.lookupToken("hey"));
			System.out.println(m.lookupToken("what"));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}

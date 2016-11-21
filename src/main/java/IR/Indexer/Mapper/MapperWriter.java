package IR.Indexer.Mapper;

import IR.Writer.ObjectWriter;
import IR.Config;

public class MapperWriter extends ObjectWriter {
		
	
	public MapperWriter(Object mapper, String mappingsPath) {
		super(mapper, mappingsPath);
	}	
	
	
	// Test Method
	public static void main(String[] args) {
		Mapper m = new Mapper();
		MapperWriter mw = new MapperWriter(m, "New");
		mw.write();
	}
}

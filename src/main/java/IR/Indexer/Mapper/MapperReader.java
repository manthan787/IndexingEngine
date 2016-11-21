package IR.Indexer.Mapper;

import IR.Reader.ObjectReader;
import IR.Config;

public class MapperReader extends ObjectReader{
	
	public MapperReader(String mappingsPath) {
		super(mappingsPath);
	}
	
	public Mapper read() {
		return (Mapper) super.read();
	}
	
	// Test method
	public static void main(String[] args) {
		MapperReader mr = new MapperReader("new");
		System.out.println(mr.read());
	}
}

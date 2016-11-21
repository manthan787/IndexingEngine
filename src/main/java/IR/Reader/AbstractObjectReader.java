package IR.Reader;

public abstract class AbstractObjectReader implements Readable{
	
	protected String path;
	
	
	public AbstractObjectReader(String mappingsPath) {
		this.path = mappingsPath;	
	}

	public abstract Object read() ; 
		
}

package IR.Writer;

public abstract class AbstractObjectWriter implements Writable {
	
	protected Object object;
	protected String path;
	
	
	public AbstractObjectWriter(Object o, String mappingsPath) {
		this.object = o;
		this.path = mappingsPath;		
	}

	public abstract void write();
}

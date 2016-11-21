package IR.Writer;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectWriter extends AbstractObjectWriter {
		
	public ObjectWriter(Object o, String mappingsPath) {
		super(o, mappingsPath);		
	}
			
	public void write() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.path));
			oos.writeObject(this.object);
			oos.close();
			System.out.println("Written to file");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

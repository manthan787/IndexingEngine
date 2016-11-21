package IR.Reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectReader extends AbstractObjectReader{
	
	public ObjectReader(String indexPath) {
		super(indexPath);
	}
	
	public Object read() {		
		try {	
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.path));
			Object o = ois.readObject();
			ois.close();
			return o;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {			
			e1.printStackTrace();
		} catch (IOException e1) {			
			e1.printStackTrace();
		}
		return null;
	}
	
}

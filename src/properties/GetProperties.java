package properties;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


//get Properties and begin the Properties of server
public class GetProperties {
	private static final String FILE_NAME = "resources/Properties.xml";

	public static MyProperties readProperties() {
		XMLDecoder decoder = null; // Create new XML file and start with NULL
		try {// try to get XML file
			decoder = new XMLDecoder(new FileInputStream(FILE_NAME));
			// begin the Properties of server
			MyProperties properties = (MyProperties) decoder.readObject();																		
			return properties;
		} catch (FileNotFoundException e) {
			creatXMLfile();
			e.printStackTrace();
		} finally {
			decoder.close();
		}
		return null;
	}
	static void creatXMLfile() {
		// Create the file XML if not found
		MyProperties properties = new MyProperties(8000, 10);															
		XMLEncoder encoder = null;
		try {
			encoder = new XMLEncoder(new FileOutputStream(FILE_NAME));
			encoder.writeObject(properties);
			System.out.println("file XML not found, created new file with default port:8000, number of client:10");
		} catch (FileNotFoundException c) {
			c.printStackTrace();
		} finally {
			encoder.close();
		}
	}
}

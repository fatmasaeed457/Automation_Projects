package help;

import java.io.FileInputStream;

import java.io.InputStream;
import java.util.Properties;

public class Base {

	static String StaticPropertyPath = System.getProperty("user.home") + System.getProperty("file.separator")
			+ "global.properties";

	public static String getStaticProperty(String property) {
		// get properties from statis property file

		String propertyValue = "";
		InputStream in = null;

		try {
			Properties props = new Properties();
			// Try to open File
			in = new FileInputStream(StaticPropertyPath);
			// Load File in RAM
			props.load(in);
			// Get the Value of the property
			propertyValue = props.getProperty(property).trim();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return propertyValue;
	}

}

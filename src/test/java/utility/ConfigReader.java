package utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class ConfigReader {

	static Properties prop = new Properties();
	public static String readProperties(String name) {
		
		String file = "C:\\Users\\baranowski\\workspace\\WH\\WilliamH\\src\\test\\java\\utility\\Configuration.properties";
		try {
			InputStream input = new FileInputStream(file);
			prop.load(input);
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(name == "firefoxPath"){
			String firefoxPath = prop.getProperty("firefoxPath");
			return firefoxPath;
		}
		if(name == "geckoPath"){
			String geckoPath = prop.getProperty("geckoPath");
			
			return geckoPath;
		}
		
		return null;
	}
}



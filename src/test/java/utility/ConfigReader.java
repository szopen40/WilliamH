package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import gherkin.deps.net.iharder.Base64.OutputStream;

public class ConfigReader {

	static Properties prop = new Properties();
	public static String readProperties(String name) {
		
		String file = "C:\\Users\\baranowski\\workspace\\WH\\WilliamH\\src\\test\\java\\utility\\Configuration.properties";
		try {
			InputStream input = new FileInputStream(file);
			prop.load(input);
			System.out.println(prop.getProperty("chromePath"));
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



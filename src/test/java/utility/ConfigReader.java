package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static Properties prop; 
	public static void main(String[] args) {
			File source = new File ("C:\\Users\\baranowski\\workspace\\WH\\WilliamH\\configs\\Configuration.properties");		
			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(source);
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			}
			
			
			//load properties file
			try {
				prop.load(fileInput);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
	}
	public static String getChromePath()
	{
		return prop.getProperty("chromePath");
	}
	public static String getFirefoxPath()
	{
		return prop.getProperty("firefoxPath");
	}
	
	public static String getgeckoPath()
	{
		return prop.getProperty("geckoPath");
	}
}



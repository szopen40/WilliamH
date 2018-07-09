package factory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.paulhammant.ngwebdriver.*;

public class WebDriverFactory {
	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();
	private static NgWebDriver ngDriver;

	/*
	 * Factory method for getting browsers
	 */
	public static WebDriver getBrowser(String browserName) {
		WebDriver driver = null;

		switch (browserName) {
		case "Firefox":
			driver = drivers.get("Firefox");
			if (driver == null) {
				System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
				System.setProperty("webdriver.gecko.driver",
						"D:\\Selenium\\geckodriver-v0.20.1-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				ngDriver = new NgWebDriver((JavascriptExecutor) driver);
				ngDriver.waitForAngularRequestsToFinish();
				drivers.put("Firefox", driver);
			}
			break;
		case "IE":
			driver = drivers.get("IE");
			if (driver == null) {
				System.setProperty("webdriver.ie.driver", "C:\\Users\\abc\\Desktop\\Server\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				//ngDriver = new NgWebDriver((JavascriptExecutor) driver);
				//ngDriver.waitForAngularRequestsToFinish();
				drivers.put("IE", driver);
			}
			break;
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver1_win32\\chromedriver.exe");
			driver = drivers.get("Chrome");
			if (driver == null) {
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//ngDriver = new NgWebDriver((JavascriptExecutor) driver);
				//ngDriver.waitForAngularRequestsToFinish();
				drivers.put("Chrome", driver);
			}
			break;
		
		case "Mobile":
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
			Map<String, Object> deviceMetrics = new HashMap<>();
			deviceMetrics.put("width", 360);
			deviceMetrics.put("height", 640);
			deviceMetrics.put("pixelRatio", 3.0);

			Map<String, Object> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceMetrics", deviceMetrics);
			mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			driver = new ChromeDriver(chromeOptions);
			//ngDriver = new NgWebDriver((JavascriptExecutor) driver);
			//ngDriver.waitForAngularRequestsToFinish();
		}
		return driver;
	}

	public static void closeAllDriver() {
		for (String key : drivers.keySet()) {
			drivers.get(key).close();
			drivers.get(key).quit();
		}
	}
}
package pages;

import org.openqa.selenium.WebDriver;

import factory.WebDriverFactory;

public class StartPage extends WebDriverFactory {
	
	protected WebDriver driver;
//	WebDriverWait wait = new WebDriverWait(driver, 5);
	
	public StartPage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage goToHomePage() {
		driver.get("https://vegas.williamhill.com/");
		return new HomePage(driver);
	}

	public void close_page() {
		driver.quit();
	}
}
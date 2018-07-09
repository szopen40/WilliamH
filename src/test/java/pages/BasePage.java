package pages;

import org.openqa.selenium.WebDriver;

import factory.WebDriverFactory;

public class BasePage extends WebDriverFactory {
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void close_page() {
		driver.quit();
	}
}
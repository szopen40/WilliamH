package pages;

import org.openqa.selenium.WebDriver;

public class StartPage {
	
	
	public WebDriver driver;
	public StartPage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage goToHomePage() {
		driver.manage().window().maximize();
		driver.get("https://vegas.williamhill.com/");
		return new HomePage(driver);
	}

	public void close_page() {
		driver.quit();
	}
}
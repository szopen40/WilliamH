package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	private By magnifier = By.xpath("//button[@data-ng-click = 'showSearchInput()']");
	
	private By searchField = By.cssSelector(".search-input__input-wrapper input");
	
	private String game_name = "Mayfair Roulette";
	
	public HomePage goToHomePage() {
		driver.get("https://vegas.williamhill.com/");
		return new HomePage(driver);
	}

	public SearchPage clickAndSearch() {
		
		driver.findElement(magnifier).click();;
		driver.findElement(searchField).sendKeys(game_name);
		return new SearchPage(driver);
	}

}

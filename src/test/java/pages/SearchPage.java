package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends StartPage {

	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	private By roulette_window = By.xpath("//h4[@class ='tile-cover__title' and contains(text(), 'Mayfair Roulette')]");
	
	private By more_button = By.cssSelector(".o-btn__inner-wrapper");

	private By play_button = By.xpath("//button[@class='o-btn o-btn--big' and contains(text(), 'Play Now')]");

	public SearchPage playTheGame() {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(roulette_window)).perform();
		driver.findElement(more_button).click();
		return new SearchPage(driver);
	}

	public LoginPage clickPlay() {
		driver.findElement(play_button).click();
		return new LoginPage(driver);
	}
}

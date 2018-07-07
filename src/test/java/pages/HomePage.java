package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends StartPage {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".btn-search-magnifier")
	WebElement magnifier;
	
	@FindBy(css = ".search-input__input-wrapper input")
	WebElement searchField;
	
	@FindBy(css =".tile-cover__title")
	WebElement roulette;
	
	@FindBy(css =".o-btn.o-btn--more")
	WebElement more;
	
	@FindBy(css =".o-btn.o-btn--big")
	WebElement play;
	
	private String game_name = "Mayfair Roulette";
	
	public HomePage clickAndSearch() {
		magnifier.click();
		searchField.sendKeys(game_name);		
		return new HomePage(driver);
	}
	
	public HomePage playTheGame() {
		Actions actions = new Actions(driver);
		actions.moveToElement(roulette).perform();
		actions.moveToElement(more).click().build().perform();
		return new HomePage(driver);
	}
	
	public LoginPage clickPlay() {
		play.click();
		return new LoginPage(driver);
	}
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PauseAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends StartPage {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".btn-search-magnifier")
	WebElement magnifier;

	@FindBy(css = ".search-input__input-wrapper input")
	WebElement searchField;

	@FindBy(xpath = "//h4[@class ='tile-cover__title' and contains(text(), 'Mayfair Roulette')]")
	WebElement roulette;

	@FindBy(css = ".o-btn__inner-wrapper")
	WebElement more;

	@FindBy(xpath = "//button[@class='o-btn o-btn--big' and contains(text(), 'Play Now')]")
	WebElement play;

	private String game_name = "Mayfair Roulette";

	public HomePage clickAndSearch() {
		magnifier.click();
		searchField.sendKeys(game_name);
		return new HomePage(driver);
	}

	public HomePage playTheGame() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(roulette));
		actions.moveToElement(roulette).perform();

		wait.until(ExpectedConditions.visibilityOf(more));
		more.click();
		return new HomePage(driver);
	}

	public LoginPage clickPlay() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(play));
		play.click();
		return new LoginPage(driver);
	}
}

package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends StartPage {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

    //JavascriptExecutor js = ((JavascriptExecutor) driver);

	@FindBy(css = ".btn-search-magnifier")
	private WebElement magnifier;

	@FindBy(css = ".search-input__input-wrapper input")
	private WebElement searchField;

	@FindBy(xpath = "//h4[@class ='tile-cover__title' and contains(text(), 'Mayfair Roulette')]")
	private WebElement roulette;

	@FindBy(css = ".o-btn__inner-wrapper")
	private WebElement more_button;

	@FindBy(xpath = "//button[@class='o-btn o-btn--big' and contains(text(), 'Play Now')]")
	private WebElement play_button;

	private String game_name = "Mayfair Roulette";

	public HomePage clickAndSearch() {
		magnifier.click();
		searchField.sendKeys(game_name);
		return new HomePage(driver);
	}

	public HomePage playTheGame() {
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(roulette));
		actions.moveToElement(roulette).perform();

		wait.until(ExpectedConditions.visibilityOf(more_button));
		more_button.click();
		return new HomePage(driver);
	}

	public LoginPage clickPlay() {
		//js.executeScript("window.scrollBy(0,100)");
		play_button.click();
		return new LoginPage(driver);
	}
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchPage extends HomePage {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	private By roulette_window = By.xpath("//h4[@class ='tile-cover__title' and contains(text(), 'Mayfair Roulette')]");
	
	private By more_button = By.cssSelector(".o-btn__inner-wrapper");

	private By play_button = By.xpath("//button[@class='o-btn o-btn--big' and contains(text(), 'Play Now')]");

	public SearchPage playTheGame() {
		try{
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(roulette_window)).perform();
		}
		catch(StaleElementReferenceException ex){
			System.out.println(ex);
			WebElement element = driver.findElement(roulette_window);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).perform();
		}
		try{
			driver.findElement(more_button).click();
		}
		catch(StaleElementReferenceException ex){ 
			System.out.println(ex);
			WebElement more_buttonElement = driver.findElement(more_button);
			more_buttonElement.click();
			
			}
		return new SearchPage(driver);
	}

	public LoginPage clickPlay() {
		driver.findElement(play_button).click();
		return new LoginPage(driver);
	}
}

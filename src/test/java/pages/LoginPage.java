package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends StartPage {

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	private By username_field = By.id("login-form-username");

	private By username_title = By.xpath("//label[contains(text(), 'Username')]");
	
	private By password_field = By.id("login-form-password");

	private By password_title = By.xpath("//label[contains(text(), 'Password')]");
	
	private By log_button = By.xpath("//*[contains(text(), 'Log in')]");
	
	private By join_now = By.cssSelector(".c-login-form__register-link");
	
	private By remember_user = By.cssSelector( "#rememberUsername");

	private By save_username = By.xpath("//label[contains(text(), 'Save username')]");
	
	private By forgot_details = By.xpath("//span[contains(text(), 'Forgot details')]");

	private By logo = By.cssSelector( ".l-login-component__logo");
	
	private By account_yet = By.xpath("//span[@class = 'c-login-form__register-text' and contains(text(),'have an account yet')]");
	
	private By button_hide = By.xpath("//span[@class = 'c-login-form__toggle-password' and contains(text(),'Hide')]");

	private By button_show = By.xpath("//span[@class = 'c-login-form__toggle-password' and contains(text(),'Show')]");

	private By login_window = By.cssSelector(".login-component__wrapper");
	
	private By close_button = By.xpath("//span[text() = 'Close']");

	public boolean usernameEnabled() {
		if (driver.findElement(username_field).isEnabled() && driver.findElement(username_title).isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean passwordEnabled() {
		if (driver.findElement(password_field).isEnabled() && driver.findElement(password_title).isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean hideAndShowEnabled() {
		if (driver.findElement(button_show).isDisplayed()) {
			driver.findElement(button_show).click();
			if (driver.findElement(button_hide).isDisplayed()) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public boolean loginWindowEnabled() {
		if (driver.findElement(login_window).isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean logoEnabled() {
		if (driver.findElement(logo).isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean forgotEnabled() {
		if (driver.findElement(forgot_details).isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean checkboxEnabled() {
		if (driver.findElement(remember_user).isEnabled() && driver.findElement(save_username).isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean joinEnabled() {
		if (driver.findElement(join_now).isEnabled()) {
			return true;
		} else
			return false;
	}
	public boolean closeEnabled() {
		if (driver.findElement(close_button).isDisplayed()) {
			return true;
		} else
			return false;
	}

	// Additional
	public boolean loginButtonVerification() {
		if (driver.findElement(log_button).isDisplayed() && !(driver.findElement(log_button).isEnabled())) {
			driver.findElement(username_field).sendKeys("someuser");
			driver.findElement(password_field).sendKeys("somepassword");
			if (driver.findElement(log_button).isEnabled()) {
				return true;
			}
			return false;
		}
		return false;
	}

}

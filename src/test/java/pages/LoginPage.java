package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends StartPage {

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login-form-username")
	WebElement username;
	
	@FindBy(id="login-form-password")
	WebElement password;
	
	@FindBy(xpath = "//*[contains(text(), 'Log in')]")
	WebElement log_button;
	
	public WebElement getUser() {
		return username;
	}
	
	public WebElement getPass() {
		return password;
	}
	
	public LoginPage logIn() {
		log_button.click();
		return new LoginPage(driver);
	}
	
}

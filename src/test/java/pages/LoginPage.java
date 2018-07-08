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

	@FindBy(id = "login-form-username")
	private WebElement username_field;

	@FindBy(xpath = "//label[contains(text(), 'Username')]")
	private WebElement username_title;

	@FindBy(id = "login-form-password")
	private WebElement password_field;

	@FindBy(xpath = "//label[contains(text(), 'Password')]")
	private WebElement password_title;

	@FindBy(xpath = "//*[contains(text(), 'Log in')]")
	private WebElement log_button;

	@FindBy(css = ".c-login-form__register-link")
	private WebElement join_now;

	@FindBy(css = "#rememberUsername")
	private WebElement remember_user;

	@FindBy(xpath = "//label[contains(text(), 'Save username')]")
	private WebElement save_username;

	@FindBy(xpath = "//span[contains(text(), 'Forgot details')]")
	private WebElement forgot_details;

	@FindBy(css = ".l-login-component__logo")
	private WebElement logo;

	@FindBy(xpath = "//span[@class = 'c-login-form__register-text' and contains(text(),'have an account yet')]")
	private WebElement account_yet;

	@FindBy(xpath = "//span[@class = 'c-login-form__toggle-password' and contains(text(),'Hide')]")
	private WebElement button_hide;

	@FindBy(xpath = "//span[@class = 'c-login-form__toggle-password' and contains(text(),'Show')]")
	private WebElement button_show;

	@FindBy(css = ".login-component__wrapper")
	private WebElement login_window;

	@FindBy(xpath = "//span[text() = 'Close']")
	private WebElement close_button;

	public boolean usernameEnabled() {
		if (username_field.isEnabled() && username_title.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean passwordEnabled() {
		if (password_field.isEnabled() && password_title.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean hideAndShowEnabled() {
		if (button_show.isDisplayed()) {
			button_show.click();
			if (button_hide.isDisplayed()) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public boolean loginWindowEnabled() {
		if (login_window.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean logoEnabled() {
		if (logo.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean forgotEnabled() {
		if (forgot_details.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean checkboxEnabled() {
		if (remember_user.isEnabled() && save_username.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean joinEnabled() {
		if (join_now.isEnabled()) {
			return true;
		} else
			return false;
	}
	public boolean closeEnabled() {
		if (close_button.isDisplayed()) {
			return true;
		} else
			return false;
	}

	// Additional
	public boolean loginButtonVerification() {
		if (log_button.isDisplayed() && !(log_button.isEnabled())) {
			username_field.sendKeys("someuser");
			password_field.sendKeys("somepassword");
			if (log_button.isEnabled()) {
				return true;
			}
			return false;
		}
		return false;
	}

}

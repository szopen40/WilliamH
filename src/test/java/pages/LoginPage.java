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
	WebElement username;

	@FindBy(xpath = "//label[contains(text(), 'Username')]")
	WebElement username_title;

	@FindBy(id = "login-form-password")
	WebElement password;

	@FindBy(xpath = "//label[contains(text(), 'Password')]")
	WebElement password_title;

	@FindBy(xpath = "//*[contains(text(), 'Log in')]")
	WebElement log_button;

	@FindBy(css = ".c-login-form__register-link")
	WebElement join_now;

	@FindBy(css = "#rememberUsername")
	WebElement remember_user;

	@FindBy(xpath = "//label[contains(text(), 'Save username')]")
	WebElement save_username;

	@FindBy(xpath = "//span[contains(text(), 'Forgot details')]")
	WebElement forgot_details;

	@FindBy(css = ".l-login-component__logo")
	WebElement logo;

	@FindBy(xpath = "//span[@class = 'c-login-form__register-text' and contains(text(),'have an account yet')]")
	WebElement account_yet;

	@FindBy(xpath = "//span[@class = 'c-login-form__toggle-password' and contains(text(),'Hide')]")
	WebElement button_hide;

	@FindBy(xpath = "//span[@class = 'c-login-form__toggle-password' and contains(text(),'Show')]")
	WebElement button_show;

	@FindBy(css = ".login-component__wrapper")
	WebElement login_window;

	@FindBy(xpath = "//span[text() = 'Close']")
	WebElement close_button;

	public boolean usernameEnabled() {
		if (username.isEnabled() && username_title.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean passwordEnabled() {
		if (password.isEnabled() && password_title.isDisplayed()) {
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

	// Additional
	public boolean loginButtonVerification() {
		if (log_button.isDisplayed() && !(log_button.isEnabled())) {
			username.sendKeys("someuser");
			password.sendKeys("somepassword");
			if (log_button.isEnabled()) {
				return true;
			}
			return false;
		}
		return false;
	}

}

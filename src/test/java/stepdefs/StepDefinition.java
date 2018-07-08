package stepdefs;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import factory.WebDriverFactory;
import pages.HomePage;
import pages.LoginPage;
import pages.StartPage;

public class StepDefinition {

	StartPage start_page;
	HomePage home_page;
	LoginPage login;

	@Given("^Navigate to webpage$")
	public void navigate_to_webpage() throws Throwable {
		WebDriver driver = WebDriverFactory.getBrowser("Chrome");
		home_page = new HomePage(driver);
		home_page.goToHomePage();

	}

	@When("^Customer clicks on magnifier button and search \"(.*?)\"$")
	public void customer_clicks_on_magnifier_button_and_search(String arg1) throws Throwable {
		home_page.clickAndSearch();
	}

	@When("^Cicks on \"(.*?)\" button followin hover over \"(.*?)\" tile$")
	public void cicks_on_button_followin_hover_over_tile(String arg1, String arg2) throws Throwable {
		home_page.playTheGame();

	}

	@When("^Customer clicks on \"(.*?)\"$")
	public void customer_clicks_on(String arg1) throws Throwable {
		login = home_page.clickPlay();
	}

	@Then("^The customer is directed to Login Window$")
	public void the_customer_is_directed_to_Login_Window() throws Throwable {
		assertTrue("Login Window is enabled: ", login.loginWindowEnabled());
	}

	@Then("^Customer is able to see logo$")
	public void customer_is_able_to_see_logo() throws Throwable {
		assertTrue("Logo is enabled: ", login.logoEnabled());
	}

	@Then("^Customer is able to see \"(.*?)\" button$")
	public void customer_is_able_to_see_button(String arg1) throws Throwable {
		assertTrue("Join now is enabled", login.joinEnabled());
	}

	@Then("^Customer is able to see \"(.*?)\" field$")
	public void customer_is_able_to_see_field(String arg1) throws Throwable {
		assertTrue("Username field and title is Enabled", login.usernameEnabled());
	}

	@Then("^Customer is able to see show/hide toogle$")
	public void customer_is_able_to_see_show_hide_toogle() throws Throwable {
		assertTrue("Password field and title is Enabled", login.passwordEnabled());
	}

	@Then("^Customer is able to see \"(.*?)\" hyperlink$")
	public void customer_is_able_to_see_hyperlink(String arg1) throws Throwable {
		assertTrue("Forgot Details now is enabled", login.forgotEnabled());
	}

	@Then("^Customer is able to see \"(.*?)\" checkbox$")
	public void customer_is_able_to_see_checkbox(String arg1) throws Throwable {
		assertTrue("Checkbox is enabled and 'save username' displayer", login.checkboxEnabled());
	}
}
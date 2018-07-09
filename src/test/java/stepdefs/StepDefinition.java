package stepdefs;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import factory.WebDriverFactory;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import pages.BasePage;

public class StepDefinition {

	BasePage start_page;
	HomePage home_page;
	SearchPage search_page;
	LoginPage login;

	@Test
	@Given("^Navigate to webpage$")
	public void navigate_to_webpage() throws Throwable {
		home_page = new HomePage(WebDriverFactory.getBrowser("Firefox"));
		home_page.goToHomePage();

	}

	@When("^The Customer clicks on magnifier button and search for Mayfair Roulette$")
	public void the_Customer_clicks_on_magnifier_button_and_search_for_Mayfair_Roulette() {
		search_page  = home_page.clickAndSearch();
	}

	@When("^Clicks on More button followin hover over Mayfair Roulette tile$")
	public void clicks_on_More_button_followin_hover_over_Mayfair_Roulette_tile() {
		search_page.playTheGame();

	}

	@When("^The Customer clicks on Play Now$")
	public void the_Customer_clicks_on_Play_Now() {
		login = search_page.clickPlay();
	}

	@Then("^The Customer is directed to Login Window$")
	public void the_Customer_is_directed_to_Login_Window() {
		assertTrue("Login Window is enabled: ", login.loginWindowEnabled());
	}

	@Then("^The Customer is able to see logo$")
	public void the_Customer_is_able_to_see_logo() {
		assertTrue("Logo is enabled: ", login.logoEnabled());
	}

	@Then("^The Customer is able to see Close button$")
	public void the_Customer_is_able_to_see_Close_button()  {
		assertTrue("close button is enabled", login.closeEnabled());
		
	}

	@Then("^The Customer is able to see Join now button$")
	public void the_Customer_is_able_to_see_Join_now_button()  {
		assertTrue("Join now is enabled", login.joinEnabled());
		
	}

	@Then("^The Customer is able to see Username field$")
	public void the_Customer_is_able_to_see_Username_field() {
		assertTrue("Username field and title is Enabled", login.usernameEnabled());
		
	}

	@Then("^The Customer is able to see Password field$")
	public void the_Customer_is_able_to_see_Password_field() {
		assertTrue("Password field and title is Enabled", login.passwordEnabled());
		
	}

	@Then("^The Customer is able to see show/hide toogle$")
	public void the_Customer_is_able_to_see_show_hide_toogle() {
		assertTrue("Show/Hide is enabled", login.hideAndShowEnabled());
		
	}
	
	@Then("^The Customer is able to see Forgot details\\? hyperlink$")
	public void the_Customer_is_able_to_see_Forgot_details_hyperlink() {
		assertTrue("Forgot Details now is enabled", login.forgotEnabled());

	}
	
	@Then("^The Customer is able to see Log in button$")
	public void the_Customer_is_able_to_see_Log_in_button() {
		assertTrue("Login is displayed", login.loginButtonDisplayed());

	}
	
	@Then("^The Customer is able to see Save username checkbox$")
	public void the_Customer_is_able_to_see_Save_username_checkbox()  {
		assertTrue("Checkbox is enabled and 'save username' displayer", login.checkboxEnabled());
	}
	@After("@tag1")
    public void afterScenario(){
		login.close_page();
        //WebDriverFactory.closeAllDriver();
    }
  
}
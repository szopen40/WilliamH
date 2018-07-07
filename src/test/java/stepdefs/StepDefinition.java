package stepdefs;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.StartPage;
import pages.WebDriverFactory;

public class StepDefinition {

	StartPage start_page;
	HomePage home_page;
	LoginPage login;
	

	@Given("^Navigate to webpage$")
	public void navigate_to_webpage() throws Throwable {
		WebDriver driver = WebDriverFactory.getBrowser("Firefox");
		home_page = new HomePage(driver);
		home_page.goToHomePage();

	}


	@When("^Click magnifier button and search proper game$")
	public void click_magnifier_button_and_search_proper_game() throws Throwable {
		home_page.clickAndSearch();
		

	}

	@When("^Hover over game,click more and play button$")
	public void hover_over_game_click_more_and_play_button() throws Throwable {
		home_page.playTheGame();
		login = home_page.clickPlay();

	}

	@Then("^Validate full login window by user(\\d+) and pass(\\d+) set$")
	public void validate_full_login_window_by_user_and_pass_set(CharSequence[] arg1, CharSequence[] arg2) throws Throwable {
		
		login.getUser().sendKeys(arg1);
		login.getPass().sendKeys(arg2);
		login.logIn();
		
	}
}
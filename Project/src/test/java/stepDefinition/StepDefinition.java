package stepDefinition;

import java.io.IOException;

import org.junit.Assert;
import org.junit.runner.RunWith;

import pageObjects.landingPage;
import pageObjects.loginPage;
import pageObjects.portalHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import resources.base;


@RunWith(Cucumber.class)
public class StepDefinition extends base

{

	@Given("^initialize browser with chrome$")
	public void initialize_browser_with_chrome() throws Throwable
	{
		// initialize
		driver = initalixeDriver();
	}
	
	@And("^navigate to \"([^\"]*)\" site$")
	public void navigate_to_something_site(String url) throws Throwable
	{

		driver.get(url);
	}
	
	@And("^Click on login link in home page to land on sign in Page$")
	public void click_on_login_link_in_home_page_to_land_on_sign_in_page() throws Throwable
	{
		System.out.println("logged in");
	}

	 @When("^user enters (.+) and (.+) and (.+) and log in$")
	 public void user_enters_something_and_something_and_log_in(String UserName, String Password, String Text)
			throws IOException
	{
		// login
		landingPage l = new landingPage(driver);
		
		if(l.getpopupSize().size()>0)
		{
			l.getpopup().click();
		}
		
		loginPage lp = l.getLogin();

		// username & password
		lp.Email().sendKeys(UserName);
		lp.Password().sendKeys(Password);
		System.out.println(Text);

		log.info(Text);
		lp.Login().click();
	}
	
	  @Then("^navigate to the \"([^\"]*)\" site$")
	    public void navigate_to_the_something_site(String newUrl) throws Throwable {
	        driver.navigate().to(newUrl);
	        
	    }

	@Then("^verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable
	{
		portalHomePage ph = new portalHomePage(driver);
		Assert.assertTrue(ph.getsearchBox().isDisplayed());
		System.out.println("all done");
	}
	
	 @Then("^Browser have to close$")
	    public void browser_have_to_close() throws Throwable {
	        driver.close();
	    }
	
}
package Academy;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.landingPage;
import resources.base;

public class validation extends base

{
	public WebDriver driver;
	landingPage l;
	public static Logger log = LogManager.getLogger(validation.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initalixeDriver();
		log.info("Driver is initialised");
		
		driver.get(prop.getProperty("url"));
		log.info("Reached to homePage");
	}
		
	
	@Test
	public void validationTitle() throws IOException
	
	{
		l = new landingPage(driver);
		Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");
		log.info("Sucessfully validated Text Message");
		
		Assert.assertEquals(l.Navigation().isDisplayed(), true);
		log.info("All the bars are visible");
	}
	
	@Test
	public void validateHeader() throws IOException
	{
		l = new landingPage(driver);
		Assert.assertEquals(l.getheader().getText(),"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Sucessfully validated Text Message");
	}
	
	
	@AfterTest
	public void Teardown() throws InterruptedException
	{
		driver.close();
	}
}
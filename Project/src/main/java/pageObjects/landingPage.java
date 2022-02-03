package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage
{

	public WebDriver driver; // no life
	
	private By signIn = By.xpath("//span[contains(text(),'Login')]");
	private By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By Navigation = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	private By header = By.cssSelector("div[class*='video-banner'] h3");
	private By popup = By.xpath("//button[contains(text(),'NO THANKS')]");
	
	public landingPage(WebDriver driver) //have life
	{
		this.driver = driver;
	}

	public loginPage getLogin()
	{
		driver.findElement(signIn).click(); // now have life driver
		loginPage lp = new loginPage(driver);
		return lp; //also return new loginPage(driver);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title); // now have life driver
	}
	
	public WebElement getpopup()
	{
		return driver.findElement(popup); // now have life driver
	}
	
	public List<WebElement> getpopupSize()
	{
		return driver.findElements(popup); // now have life driver
	}
	
	
	public WebElement Navigation()
	{
		return driver.findElement(Navigation); // now have life driver
	}
	

	public WebElement getheader()
	{
		return driver.findElement(header); // now have life driver
	}
}
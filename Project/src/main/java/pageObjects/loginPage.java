package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage
{

	public WebDriver driver;
	
	By Email = By.xpath("//input[@id='user_email']");
	By Password = By.xpath("//input[@id='user_password']");
	By Login = By.xpath("//input[@value='Log In']");
	By ForgotPassword =By.cssSelector("[href*='password/new']");
			
	public loginPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public WebElement Email()
	{
		return driver.findElement(Email);
	}
	
	public WebElement Password()
	{
		return driver.findElement(Password);
	}
	
	public WebElement Login()
	{
		return driver.findElement(Login);
	}
	
	public ForgotPassword  ForgotPassword()
	{
		 driver.findElement(ForgotPassword).click();
		 return new ForgotPassword(driver);
	}
	
	
}
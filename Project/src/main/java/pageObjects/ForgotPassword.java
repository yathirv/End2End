package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ForgotPassword

{
	
	public WebDriver driver;
	
	By Email = By.xpath("//input[@id='user_email']");
	By Send = By.cssSelector("input[value='Send Me Instruction']");
	
	
	public ForgotPassword(WebDriver driver)
	{
		this.driver = driver;
	}


	public WebElement Email()
	{
		return driver.findElement(Email);
	}
	
	public WebElement Send()
	{
		return driver.findElement(Send);
	}
	
}

package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.base;

public class homePage extends base

{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	
	@DataProvider(name = "Authentication")
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "non-restrictedUser@gmail.com";
		data[0][1] = "123456778";
		data[0][2] = "non-restricted User";

		data[1][0] = "restrictedUser@gmail.com";
		data[1][1] = "87654321";
		data[1][2] = "restricted User";

		return data;

	}
	

	@Test(dataProvider = "Authentication")
	public void basePageNavigation(String UserName, String Password, String Text) throws IOException {

		driver = initalixeDriver();
		driver.get(prop.getProperty("url"));
		
		landingPage l = new landingPage(driver);
		loginPage lp = l.getLogin();
		
		lp.Email().sendKeys(UserName);
		lp.Password().sendKeys(Password);
//		System.out.println(Text);
		log.info(Text);
		lp.Login().click();
		
		ForgotPassword fp = lp.ForgotPassword();
		fp.Email().sendKeys("XXX@gmail.com");
		fp.Send().click();
		
		driver.close();
	}
	
}
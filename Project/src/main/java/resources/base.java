package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base
{
	public WebDriver driver;
	public Properties prop;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	public WebDriver initalixeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
//		mvn test -Dbrowser=chrome
		String browserName = System.getProperty("browser");
//		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if (browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/yathi/Documents/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless"))
			{
//			options.addArguments("headless");
			options.setHeadless(true);
			}
			driver = new ChromeDriver(options);
		}
		else if (browserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("IE"))
		{
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public static String getScreenShotPath(String testcaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}
}

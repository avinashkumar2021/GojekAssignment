package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

		
	public static WebDriver startApplication(String appUrl,String browserName)
	{
		
	WebDriver driver=null;	
		
	if(browserName.equalsIgnoreCase("Chrome"))
	{
		ChromeOptions option=new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		option.addArguments("--disable-notifications");
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
	}
	else if(browserName.equalsIgnoreCase("Firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		 
	}
	
	
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.get(appUrl);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	return driver;
	
	}
	
	
	public static void closeApplication(WebDriver driver)
	{
		driver.quit();
	}
	
}

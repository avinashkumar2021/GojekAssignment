package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankPassword {
	
	WebDriver driver;
	WebDriverWait wait2;
	JavascriptExecutor executor;
	
	@FindBy(xpath="//input[@type='password']")
    WebElement Password_input;
	
	@FindBy(xpath="//button[@name='ok']")
    WebElement ok_Btn;
	
	@FindBy(xpath="//div[@class='card-container full']/div/i//following::div[2]")
    WebElement ConfirmationMessage_txt;
	
	
	
	
	private BankPassword(WebDriver driver) {
    	
		wait2 = new WebDriverWait(driver,100);
    	executor= (JavascriptExecutor) driver;
    	driver.switchTo().frame(0);
        PageFactory.initElements(driver, this);
    }

    public static BankPassword using(WebDriver driver) {
        return new BankPassword(driver);
    }
    
    
    public BankPassword setBankOtp(String OTP) throws Exception {
 	   wait2.until(ExpectedConditions.elementToBeClickable(Password_input));
 	   //Thread.sleep(40000);
 	   //executor.executeScript("arguments[0].value=’112233’;", this.Password_input);
 	   this.Password_input.sendKeys(OTP);
 	   return this;
}
    public BankPassword submitOtp() throws Exception {
 	   this.ok_Btn.click();
 	   Thread.sleep(2000);
 	  return this;
 	   }
    
    
    
}

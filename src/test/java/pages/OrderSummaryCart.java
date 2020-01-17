package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSummaryCart {
	
	
	WebDriver driver;
	WebDriverWait wait2;
	JavascriptExecutor executor;
	

    @FindBy(xpath="//span[contains(text(),'Continue')]")
    WebElement Continue_Btn;
    
    @FindBy(xpath="//a[@class='list with-promo']")
    WebElement CreditCardPaymet_Link;
    
    
    
    @FindBy(xpath="//input[@name='cardnumber']")
    WebElement CardNumber_input;
    
    @FindBy(xpath="//input[@placeholder='MM / YY']")
    WebElement ExpiryDate_input;
    
    
    @FindBy(xpath="//input[@placeholder='123']")
    WebElement cvv_input;
    
    @FindBy(xpath="//*[contains(text(),'Pay Now')]")
    WebElement PayNow_Button;
    
    @FindBy(xpath="//input[@type='password']")
    WebElement Password_input;
    
    
    
    
    
    
    private OrderSummaryCart(WebDriver driver) {
    	wait2 = new WebDriverWait(driver,100);
    	executor= (JavascriptExecutor) driver;
    	driver.switchTo().frame(0);
        PageFactory.initElements(driver, this);
    }

    public static OrderSummaryCart using(WebDriver driver) {
        return new OrderSummaryCart(driver);
    }
    
    
    public OrderSummaryCart   clickContinue() throws Exception {
    	Thread.sleep(5000);
    	executor.executeScript("arguments[0].click();", this.Continue_Btn);
    	
    	return this;
    	
    	
    }
    
public   OrderSummaryCart clickOnPayment() throws Exception {
	
    	executor.executeScript("arguments[0].click();", this.CreditCardPaymet_Link);
    	//Thread.sleep(15000);
		return this;
    	
    	
    }

   public OrderSummaryCart setCardNumber(String CardNumber) {
	   this.CardNumber_input.sendKeys(CardNumber);
	   return this;
   }
   
   public OrderSummaryCart setExpiryDate(String ExpiryDate) {
	   this.ExpiryDate_input.sendKeys(ExpiryDate);
	   return this;
   }
   
   public OrderSummaryCart setCVV(String cvv) {
	   this.cvv_input.sendKeys(cvv);
	   return this;
   }
   
   public OrderSummaryCart submitPayment() throws InterruptedException {
	   //this.PayNow_Button.click();
	   executor.executeScript("arguments[0].click();", this.PayNow_Button);
	   Thread.sleep(10000);
	   return this;
	   
   }
   
   public OrderSummaryCart setBankOtp(String OTP) throws Exception {
	   wait2.until(ExpectedConditions.elementToBeClickable(Password_input));
	   //Thread.sleep(40000);
	   executor.executeScript("arguments[0].value=’Avinash Mishra’;", this.Password_input);
	   this.Password_input.sendKeys(OTP);
	   return this;
	   
   }
   
   
    
    

    
    
    
}

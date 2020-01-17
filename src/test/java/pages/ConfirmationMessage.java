package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationMessage {
	
	WebDriver driver;
	WebDriverWait wait2;
	JavascriptExecutor executor;
	
	@FindBy(xpath="//div[@class='card-container full']/div/i//following::div[2]")
    WebElement ConfirmationMessage_txt;
	
	private ConfirmationMessage(WebDriver driver) {
		driver.switchTo().frame(0);
    	wait2 = new WebDriverWait(driver,100);
    	
        PageFactory.initElements(driver, this);
    }

    public static ConfirmationMessage using(WebDriver driver) {
        return new ConfirmationMessage(driver);
    }
    
    public String getTransactionMessage() throws Exception {
    	//wait2.until(ExpectedConditions.visibilityOf((ConfirmationMessage_txt)));
   	   String ConfirmationMessage=this.ConfirmationMessage_txt.getText();
   	   
 	return ConfirmationMessage;
   	   }

}

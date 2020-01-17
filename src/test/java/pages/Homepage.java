package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	WebDriver driver;

    @FindBy(xpath="//a[@class='btn buy']")

    private WebElement BuyNow_Btn;
    
    
    private Homepage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static Homepage using(WebDriver driver) {
        return new Homepage(driver);
    }
    
    public  void ClickBuyNow() {
    	
    	this.BuyNow_Btn.click();
        
    }

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
	

	WebDriver driver;

    @FindBy(xpath="//a[@class='btn buy']")
     WebElement BuyNow_Btn;
    
    @FindBy(xpath="//td[contains(.,'Name')]//following::td[1]/input")
    WebElement Name_inpt;

    
    @FindBy(xpath="//td[contains(.,'Email')]//following::td[1]/input")
    WebElement Email_inpt;
    
    @FindBy(xpath="//td[contains(.,'Phone no')]//following::td[1]/input")
    WebElement Phone_no_inpt;
    
    @FindBy(xpath="//td[contains(.,'City')]//following::td[1]/input")
    WebElement City_inpt;
    
    @FindBy(xpath="//td[contains(.,'Postal Code')]//following::td[1]/input")
    WebElement PostalCode_inpt;
    
    @FindBy(xpath="//div[@class='cart-checkout']")
    WebElement CheckOut_Btn;
    
    
    
    
    
    
    
    private ShoppingCart(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static ShoppingCart using(WebDriver driver) {
        return new ShoppingCart(driver);
    }
    
    
    public  ShoppingCart setName(String Name) {
          
    	this.Name_inpt.clear();
    	this.Name_inpt.sendKeys(Name);
    	return this;
    }
    
    public  ShoppingCart setEmail(String Email) {
    	this.Email_inpt.clear();
    	this.Email_inpt.sendKeys(Email);
    	return this;
    }
    
    public  ShoppingCart setPhoneNo(String PhoneNo) {
    	this.Phone_no_inpt.clear();
    	this.Phone_no_inpt.sendKeys(PhoneNo);
    	return this;
    }
      public  ShoppingCart setCity(String City) {
    	  this.City_inpt.clear();
    	this.City_inpt.sendKeys(City);
    	return this;
    }
      
      
      public  ShoppingCart setPostalCode(String PostalCode) {
    	  this.City_inpt.clear();  
      	this.PostalCode_inpt.sendKeys(PostalCode);
      	return this;
      }
      public void   clickCheckOut() throws Exception {
    	  
          
        	this.CheckOut_Btn.click();
        	
        	
        }
    
    
}

package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BankPassword;
import pages.ConfirmationMessage;
import pages.Homepage;
import pages.OrderSummaryCart;
import pages.ShoppingCart;
import utility.ExcelUtils;

public class TC_01 extends BaseClass{
	
	
	
	
	
	@Test(dataProvider = "TestData")
	public void validateSuccessfullTransaction(String Name,String Email,String PhoneNo,String City,String PostalCode,String CardNumber,String ExpiryDate,String cvv,String Otp) throws Exception {
		logger=extent.startTest(ExcelUtils.getTestCaseName(this.toString()));
		
		
		
		
		Homepage.using(driver)
		        .ClickBuyNow();
		
		ShoppingCart.using(driver)
		            .setName(Name)
		            .setEmail(Email)
		            .setPhoneNo(PhoneNo)
		            .setCity(City)
		            .setPostalCode(PostalCode)
		            .clickCheckOut();
		
		
		OrderSummaryCart.using(driver)
		                .clickContinue()
		                .clickOnPayment()
		                .setCardNumber(CardNumber)
		                .setExpiryDate(ExpiryDate)
		                .setCVV(cvv)
		                .submitPayment();
		    BankPassword.using(driver)
		                .setBankOtp(Otp)
		                .submitOtp();
		    
		   String Message= ConfirmationMessage.using(driver)
		                       .getTransactionMessage();
		
		                
		   Assert.assertEquals(Message, "Transaction successful");
		
		
		System.out.println(Message);
		               
		
		
	}
	
	
}

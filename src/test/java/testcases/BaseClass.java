package testcases;

import factory.BrowserFactory;
import utility.ExcelUtils;
import utility.ExtentManager;
import utility.Helper;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass {

	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger;
	String path;
	private String sTestCaseName;
	 
	 private int iTestCaseRow;
	

	@BeforeSuite
	public void setupTestSuite() {

		extent=ExtentManager.getInstance();

	}

	/*@BeforeClass
	public void setup() {
		driver = BrowserFactory.startApplication(DataProviderFactory.getConfig().getStagingURL(),
				DataProviderFactory.getConfig().getBrowser());
	}*/
	
	@Parameters({"url","browser"})
	@BeforeClass
	public void setup(String testURL,String testBrowser) {
		driver = BrowserFactory.startApplication(testURL,testBrowser);
		
	}

	@AfterMethod
	public void tearDownTest(ITestResult result) throws Exception {
	/*

		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Passed test"+logger.addScreenCapture(Helper.captureScreenshot(driver)));
			
			
		} else if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Failed test "+logger.addScreenCapture(Helper.captureScreenshot(driver)));
			
		}
		*/

}
	
	@AfterClass
	public void tearDown() {
		//BrowserFactory.closeApplication(driver);
		//driver.get(path);
		//driver.close();
		
	}

	
	@AfterSuite
	public void closed() {
	
	driver.get(ExtentManager.reportpath);
	driver.quit();
	
	}
	
	
	@DataProvider(name="TestData")
	 
	  public Object[][] Authentication() throws Exception{
	 
	     // Setting up the Test Data Excel file
	 
	 
	 ExcelUtils.setExcelFile(System.getProperty("user.dir")+"\\TestData\\TestData.xlsx","TestData");
	 sTestCaseName = this.toString();
	 
	    // From above method we get long test case name including package and class name etc.
	 
	    // The below method will refine your test case name, exactly the name use have used
	 
	    sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
	    		
	 
	     // Fetching the Test Case row number from the Test Data Sheet
	 
	     // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
	 
	 iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
	 
	     Object[][] testObjArray = ExcelUtils.getTableArray(System.getProperty("user.dir")+"\\TestData\\TestData.xlsx","TestData",iTestCaseRow);
	    	
	 
	      return (testObjArray);
	 
	 }
	 

	
	
	}



package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	
	public static ExtentReports getInstance() {
		
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		File file = new File(dateformat.format(date)+".html");
		ExtentReports extent = new ExtentReports(System.getProperty("user.dir") +"\\Reports\\TestResult_"+file,false);
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		extent.addSystemInfo("Environment","Automation Testing")
		       .addSystemInfo("User Name","Avinash Kumar");
		return extent;
	}
	
	public static String startReporting() {
		
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		for(StackTraceElement t:stacktrace) {
			System.out.println(t.getMethodName());
		}
		StackTraceElement e = stacktrace[2];
		String methodName = e.getMethodName();
		return methodName;
	}

}

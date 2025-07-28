package listnersUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Baseclass.BaseClass;
//import baseClass.Baseclass;

public class ListnersImplemention implements ITestListener, ISuiteListener{
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	
	public void onStart(ISuite suite) {
		Reporter.log("report configuration",true);
		Date d= new Date();
		String newdate = d.toString().replace(" ", "_").replace(":", "_");
		spark = new ExtentSparkReporter("./AdvanceReports/report_"+newdate+".html");
		spark.config().setDocumentTitle("NizaCRM ITest results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows11");
		report.setSystemInfo("Browser", "Edge");
		
		
		
	}

	public void onFinish(ISuite suite) {
		report.flush();
		Reporter.log("Report backup",true);
	
	}

	public void onTestStart(ITestResult result) {
		test= report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO,"===" +result.getMethod().getMethodName()+"execution started");
	
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		Reporter.log("====="+testname+"FAILURE====", true);
		Date d =new Date();
		String newdate = d.toString().replace("" , " ").replace(":", "_");
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm=new File("./errorsnap/"+testname+""+newdate+".png");
		//temp.renameTo(perm);
		//FileHandler.copy(temp, perm);
		try {
			org.openqa.selenium.io.FileHandler.copy(temp, perm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}

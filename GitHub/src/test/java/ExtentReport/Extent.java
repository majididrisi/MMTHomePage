package ExtentReport;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Extent {
	ExtentReports exrpt1;
	
	@BeforeTest
	public void reportConfig() 
	{
	String path = System.getProperty("user.dir") +	"\\reports\\index.html";
	
	ExtentSparkReporter rpt1 = new ExtentSparkReporter(path);
	rpt1.config().setReportName("Report 24th May");
	
	exrpt1 = new ExtentReports();
	exrpt1.attachReporter(rpt1);
	}
	
	@Test
	public void testCase()
	{
		ExtentTest test = exrpt1.createTest("testCase") ;
		System.out.println("This test Case uses Extent Reports");
		test.fail("Test Case Failed");
		exrpt1.flush();
	}
}

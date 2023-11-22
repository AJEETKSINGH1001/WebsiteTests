package Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class WebsiteURLReports {
    private WebDriver driver;
    private ExtentReports extentReports;
    private ExtentTest extentTest;

    @BeforeMethod
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ajeet\\Documents\\chromedriver.exe");
        driver = new ChromeDriver();

        // Initialize ExtentReports
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    @Test
    public void testValidWebsiteURL() {
        extentTest = extentReports.createTest("testValidWebsiteURL");
        extentTest.log(Status.INFO, "Test started");

        String expectedURL = "https://www.flipkart.com/";
        driver.get(expectedURL);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "URL mismatch");

        extentTest.log(Status.PASS, "URL validation successful");
    }

      //This is test for invalid url invoke
    @Test
    public void testInvalidWebsiteURL() {
    	 extentTest = extentReports.createTest("testInvalidWebsiteURL");
         extentTest.log(Status.INFO, "Test started");
        String expectedURL = "https://www.flipkart.com/";
        driver.get("https://www.flipkarts.com");
        String actualURL = driver.getCurrentUrl();
        Assert.assertNotEquals(actualURL, expectedURL, "URLs should not match");
        extentTest.log(Status.PASS,"url not matched");
    }
    
   //This is test for searching a product in url
    
    @Test
    public void testURLWithQueryString() {
   	 extentTest = extentReports.createTest("testURLWithQueryString");
     extentTest.log(Status.INFO, "Test started");
        String expectedURL = "https://www.flipkart.com/search?q=phone";
        driver.get(expectedURL);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "URL mismatch");
        extentTest.log(Status.PASS,"URL mismatch");
    }
    
    
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, "Test case failed: " + result.getName());
            extentTest.log(Status.FAIL, "Failure details: " + result.getThrowable());
        }
        
        if (extentReports != null) {
            extentReports.flush();
        }

        driver.quit();
    }
}

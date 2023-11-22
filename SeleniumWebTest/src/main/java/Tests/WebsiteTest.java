package Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebsiteTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set the path to the ChromeDriver executable
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ajeet\\Documents\\chromedriver.exe");
        
        // Create a new instance of ChromeDriver
        driver = new ChromeDriver();
    }

    @Test
    public void launchWebsite() {
        // Open a website
        String websiteURL = "https://www.flipkart.com/";
        driver.get(websiteURL);

        // You can add assertions or other test actions here
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

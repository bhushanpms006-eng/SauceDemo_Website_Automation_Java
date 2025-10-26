package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class BaseTest {
    public WebDriver driver;
    public Logger log;

    @BeforeClass
    public void setup() {
        log = LogManager.getLogger(BaseTest.class);
        log.info("🚀 Starting Browser");

        // Optional: Use WebDriverManager
        // WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        log.info("Opened URL: https://www.saucedemo.com/");
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                File dest = new File("screenshots/" + result.getName() + ".png");
                FileUtils.copyFile(src, dest);
                log.error(" Test Failed: " + result.getName() + " | Screenshot saved at: " + dest.getAbsolutePath());
            } catch (IOException e) {
                log.error("Exception while taking screenshot: " + e.getMessage());
            }
        }
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
            log.info(" Browser Closed");
        }
    }
}

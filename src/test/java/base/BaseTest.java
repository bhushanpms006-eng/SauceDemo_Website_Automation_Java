package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.ConfigReader;
import utilities.LoggerHelper;
import org.apache.logging.log4j.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected Logger log;

    @BeforeClass
    public void setUp() {
        // Load configuration file
        ConfigReader.loadConfig();
        log = LoggerHelper.getLogger(BaseTest.class);

        log.info(" Starting SauceDemo Automation Tests");

        // Initialize WebDriver based on configuration
        String browser = ConfigReader.get("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup(); 
            driver = new ChromeDriver();
        } else {
            throw new RuntimeException(" Unsupported browser: " + browser);
        }

        // Browser setup
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Launch application
        String url = ConfigReader.get("url");
        driver.get(url);
        log.info(" Launched URL: " + url);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            log.info(" Browser closed successfully.");
        }
    }
}

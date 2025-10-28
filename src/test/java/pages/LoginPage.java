package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.LoggerHelper;
import org.apache.logging.log4j.Logger;

public class LoginPage {
    private WebDriver driver;
    private Logger log;

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginBtn = By.id("login-button");
    private By logoText = By.xpath("//div[contains(text(),'Swag Labs')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.log = LoggerHelper.getLogger(LoginPage.class);
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();

        String logo = driver.findElement(logoText).getText();
        Assert.assertEquals(logo, "Swag Labs", " Login failed!");
        log.info(" User logged in successfully!");
    }
}

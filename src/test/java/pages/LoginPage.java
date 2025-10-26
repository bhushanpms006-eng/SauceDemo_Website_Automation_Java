package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.apache.logging.log4j.Logger;

public class LoginPage {
    private WebDriver driver;
    private Logger log;

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");
    private By loginLogo = By.xpath("//div[contains(text(),'Swag Labs')]");

    public LoginPage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();

        String logoText = driver.findElement(loginLogo).getText();
        Assert.assertEquals(logoText, "Swag Labs", " Login failed!");
        log.info(" User logged in successfully!");
    }
}

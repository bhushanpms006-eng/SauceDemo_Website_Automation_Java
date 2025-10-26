package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ConfirmationPage {
    private WebDriver driver;
    private By confirmationMsg = By.xpath("//h2[contains(text(),'Thank you for your order!')]");

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyOrderConfirmation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMsg)).getText();
        Assert.assertTrue(msg.contains("Thank you for your order!"), " Order confirmation message not found!");
        System.out.println("Yes " + msg);
    }
}

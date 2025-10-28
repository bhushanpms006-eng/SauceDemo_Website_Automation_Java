package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.apache.logging.log4j.Logger;
import utilities.LoggerHelper;

public class CartPage {
    private WebDriver driver;
    private Logger log;

    private By cartItem = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.log = LoggerHelper.getLogger(CartPage.class);
    }

    public void verifyProductInCart() {
        String productName = driver.findElement(cartItem).getText();
        Assert.assertTrue(productName.contains("Backpack"), " Product not found in cart!");
        log.info(" Product verified in cart successfully!");
    }
}

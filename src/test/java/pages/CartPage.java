package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;

public class CartPage {
    private WebDriver driver;
    private Logger log;
    private By checkoutBtn = By.id("checkout");

    public CartPage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutBtn).click();
        log.info(" Proceeded to checkout page!");
    }
}

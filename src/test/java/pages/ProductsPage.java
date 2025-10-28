package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.apache.logging.log4j.Logger;
import utilities.LoggerHelper;
import java.util.List;

public class ProductsPage {
    private WebDriver driver;
    private Logger log;

    private By productNames = By.xpath("//div[@class='inventory_item_name ']");
    private By sortDropdown = By.className("product_sort_container");
    private By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By cartLink = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.log = LoggerHelper.getLogger(ProductsPage.class);
    }

    public void verifyProductsDisplayed() {
        List<WebElement> products = driver.findElements(productNames);
        Assert.assertTrue(products.size() > 0, " No products found!");
        log.info(" Products are displayed successfully.");
    }

    public void sortProducts(String sortType) {
        driver.findElement(sortDropdown).click();
        driver.findElement(By.xpath("//option[contains(text(),'" + sortType + "')]")).click();
        log.info(" Sorting functionality verified: " + sortType);
    }

    public void addProductToCart() {
        driver.findElement(addToCartBtn).click();
        driver.findElement(cartLink).click();
        log.info(" Product successfully added to cart!");
    }
}

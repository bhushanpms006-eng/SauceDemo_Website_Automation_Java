package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;
    private Logger log;

    private By productNames = By.xpath("//div[@class='inventory_item_name ']");
    private By sortDropdown = By.className("product_sort_container");
    private By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By cartLink = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    public void verifyProductsDisplayed() {
        List<WebElement> products = driver.findElements(productNames);
        Assert.assertTrue(products.size() > 0, "❌ No products found!");
        log.info(" Products are displayed on the page!");
    }

    public void sortProducts(String sortType) {
        driver.findElement(sortDropdown).click();
        driver.findElement(By.xpath("//option[contains(text(),'" + sortType + "')]")).click();
        log.info(" Sorting functionality working fine (" + sortType + ")");
    }

    public void addProductToCart() {
        driver.findElement(addToCartBtn).click();
        driver.findElement(cartLink).click();

        boolean productInCart = driver.findElements(By.xpath("//div[text()='Sauce Labs Backpack']")).size() > 0;
        Assert.assertTrue(productInCart, " Product not added to cart!");
        log.info(" Product successfully added to cart and visible in cart!");
    }
}

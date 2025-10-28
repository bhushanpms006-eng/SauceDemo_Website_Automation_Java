package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import utilities.ConfigReader;
import utilities.ScreenshotUtil;

public class TestSauceDemo extends BaseTest {

    @Test
    public void testCompleteFlow() {
        try {
            LoginPage login = new LoginPage(driver);
            ProductsPage products = new ProductsPage(driver);
            CartPage cart = new CartPage(driver);

            login.login(ConfigReader.get("username"), ConfigReader.get("password"));
            products.verifyProductsDisplayed();
            products.sortProducts("Name (Z to A)");
            products.addProductToCart();
            cart.verifyProductInCart();

        } catch (Exception e) {
            ScreenshotUtil.captureScreenshot(driver, "test_failure");
            log.error(" Test failed: " + e.getMessage());
            throw e;
        }
    }
}

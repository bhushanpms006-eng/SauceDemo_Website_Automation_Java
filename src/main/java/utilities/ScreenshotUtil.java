package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String fileName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(srcFile.toPath(), Paths.get("screenshots/" + fileName + ".png"));
        } catch (IOException e) {
            System.out.println(" Failed to capture screenshot: " + e.getMessage());
        }
    }
}

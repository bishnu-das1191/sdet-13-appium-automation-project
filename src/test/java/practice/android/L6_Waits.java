package practice.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class L6_Waits {
    public static void main(String[] args) throws MalformedURLException {

        /**
         *  Waits in Appium
         */
        AppiumDriver driver = L1_CreateDriverSession.initializeDriver("Android");

        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        By alertViews = AppiumBy.accessibilityId("OK Cancel dialog with a message");
        By cancelBtn = AppiumBy.id("android:id/button2");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertViews)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cancelBtn)).click();

    }
}

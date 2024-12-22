package practice.android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;

public class L3_ElementsBasicActions {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

       AppiumDriver driver =  L1_CreateDriverSession.initializeDriver("Android");

        By views = AppiumBy.accessibilityId("Views");
        By textFields = AppiumBy.accessibilityId("TextFields");
        By editText = AppiumBy.id("io.appium.android.apis:id/edit");

        driver.findElement(views).click();

        //swipe up code
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(), "direction", "up","percent", 0.75));

        driver.findElement(textFields).click();
        driver.findElement(editText).sendKeys("Appium session by GFG");
        Thread.sleep(2000);
        driver.findElement(editText).clear();

    }
}

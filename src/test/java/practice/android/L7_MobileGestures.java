package practice.android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.time.Duration;

public class L7_MobileGestures {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        /**
         *  Automate Mobile Gestures
         */
        AppiumDriver driver = L1_CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //longClickGesture(driver);
        //dragGesture(driver);
        //zoomInGesture(driver);
        //swipeLeft(driver);
        swipeRight(driver);
    }

    public static void longClickGesture(AppiumDriver driver) {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        //long click Gesture by using web element
        /*driver.executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),
                "duration", 1000));*/

        // long click Gesture by using co-ordinates
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", 217,
                "y", 550,
                "duration", 1000
        ));
    }


    public static void dragGesture(AppiumDriver driver) {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 649,
                "endY", 662
        ));
    }

    public static void zoomInGesture(AppiumDriver driver) throws InterruptedException {

        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Skip\"]")).click();
        Thread.sleep(5000);

        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
           "left", 200,
           "top", 460,
           "width", 600,
           "height", 600,
           "percent", 0.90
        ));
    }

    public static void swipeLeft(AppiumDriver driver) throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]"));

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "left",
                "percent", 0.15
        ));
    }


    public static void swipeRight(AppiumDriver driver) throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]"));

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "left",
                "percent", 0.15
        ));

        Thread.sleep(2000);
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "right",
                "percent", 0.50
        ));

    }


}

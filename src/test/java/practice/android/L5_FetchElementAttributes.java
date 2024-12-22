package practice.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class L5_FetchElementAttributes {

    public static void main(String[] args) throws MalformedURLException {

        /**
         *   How to fetch element attributes
         */

        AppiumDriver driver = L1_CreateDriverSession.initializeDriver("Android");

        By accessibility = AppiumBy.accessibilityId("Accessibility");

        System.out.println("Label is : "+driver.findElement(accessibility).getText());

        System.out.println("Text : "+driver.findElement(accessibility).getDomAttribute("text"));

        System.out.println("enable : " +driver.findElement(accessibility).getDomAttribute("enabled"));

        System.out.println("clickable : " +driver.findElement(accessibility).getDomAttribute("clickable"));

    }
}

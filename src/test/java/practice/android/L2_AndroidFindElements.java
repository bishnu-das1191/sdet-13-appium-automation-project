package practice.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

public class L2_AndroidFindElements {

    public static void main(String[] args) throws MalformedURLException {

        AppiumDriver driver = L1_CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement element = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println(element.getText());

        WebElement elementById = driver.findElements(AppiumBy.className("android.widget.TextView")).get(2);
        System.out.println(elementById.getText());


        WebElement elementByXpath = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
        System.out.println(elementByXpath.getText());

        System.out.println("Print all the Menu items ");

        List<WebElement> menuList = driver.findElements(AppiumBy.id("android:id/text1"));
        System.out.println("Total Menu Items : "+ menuList.size());
        for(WebElement menu : menuList){
            System.out.println(menu.getText());
        }

        System.out.println("List Ends here.. ");

        //find element using Ui Selector
        WebElement elementByUiSelector = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        System.out.println(elementByUiSelector.getText());
    }
}

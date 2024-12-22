package practice.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class L8_E2E_Test {

    AppiumDriver driver;

    @BeforeClass
    public void beforeCls() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("medium_phone")
                .setAutomationName("uiautomator2")
                .setAppPackage("com.swaglabsmobileapp")
                .setAppActivity("com.swaglabsmobileapp.MainActivity")
                .setAvdLaunchTimeout(Duration.ofSeconds(180))
                .setAvd("Medium_Phone_API_35")
                .setNewCommandTimeout(Duration.ofSeconds(300));

        URL url = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(url, options);
        System.out.println("Session ID : "+driver.getSessionId());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void verifyInvalidUsernameTest() throws InterruptedException {

        WebElement username = driver.findElement(AppiumBy.accessibilityId("test-Username"));
        WebElement password = driver.findElement(AppiumBy.accessibilityId("test-Password"));
        WebElement loginButton = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));

        username.sendKeys("invalidusername");
        password.sendKeys("secret_sauce");
        loginButton.click();

        String expectedErrorMsg = "Username and password do not match any user in this service.";

        WebElement errTextElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]"));

        Thread.sleep(2000);

        String actualErrorMsg = errTextElement.getDomAttribute("text");
        System.out.println(actualErrorMsg);
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

    }


    @Test
    public void verifyInvalidPasswordTest() throws InterruptedException {

        WebElement username = driver.findElement(AppiumBy.accessibilityId("test-Username"));
        WebElement password = driver.findElement(AppiumBy.accessibilityId("test-Password"));
        WebElement loginButton = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));

        username.sendKeys("standard_user");
        password.sendKeys("invalidpassword");
        loginButton.click();

        String expectedErrorMsg = "Username and password do not match any user in this service.";

        WebElement errTextElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]"));

        Thread.sleep(2000);

        String actualErrorMsg = errTextElement.getDomAttribute("text");
        System.out.println(actualErrorMsg);
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

    }


    @Test
    public void verifySuccessfulLoginTest() throws InterruptedException {

        WebElement username = driver.findElement(AppiumBy.accessibilityId("test-Username"));
        WebElement password = driver.findElement(AppiumBy.accessibilityId("test-Password"));
        WebElement loginButton = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();

        String expectedTitleText = "PRODUCTS";

        WebElement productsTextElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]"));

        Thread.sleep(2000);

        String actualProductTitleText = productsTextElement.getDomAttribute("text");
        System.out.println(actualProductTitleText);
        Assert.assertEquals(actualProductTitleText, expectedTitleText);
    }


}

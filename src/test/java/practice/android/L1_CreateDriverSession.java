package practice.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class L1_CreateDriverSession {

    public static void main(String[] args) throws MalformedURLException {

        //when u need to install the app everytime and then start testing
/*
        String appURL = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";

        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("medium_phone")
                .setAutomationName("uiautomator2")
                .setApp(appURL);

        URL url = new URL("http://127.0.0.1:4723");
        AppiumDriver driver = new AndroidDriver(url, options);*/


        // use this when you android app already installed in device
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("medium_phone")
                .setAutomationName("uiautomator2")
                .setAppPackage("io.appium.android.apis")
                .setAppActivity("io.appium.android.apis.ApiDemos")
                .setAvdLaunchTimeout(Duration.ofSeconds(180))
                .setAvd("Medium_Phone_API_35")
                .setNewCommandTimeout(Duration.ofSeconds(300));

        URL url = new URL("http://127.0.0.1:4723");
        AppiumDriver driver = new AndroidDriver(url, options);
        System.out.println("Driver Session Id : "+driver.getSessionId());




    }


    public static AndroidDriver initializeDriver(String platformName) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("medium_phone")
                .setAutomationName("uiautomator2")
                .setAppPackage("io.appium.android.apis")
                .setAppActivity("io.appium.android.apis.ApiDemos")
//                .setAppPackage("com.google.android.apps.maps")
//                .setAppActivity("com.google.android.maps.MapsActivity")
                .setAvdLaunchTimeout(Duration.ofSeconds(180))
                .setAvd("Medium_Phone_API_35")
                .setNewCommandTimeout(Duration.ofSeconds(300));

        URL url = new URL("http://127.0.0.1:4723");
        return new AndroidDriver(url, options);
    }
}

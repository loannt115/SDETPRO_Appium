package api_learning;

import driver.AppPackages;
import driver.DriverFactory;
import driver.MobileCapabilityTypeEx;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.time.Duration;

public class HandleMultipleApps implements MobileCapabilityTypeEx {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {
            MobileElement navLoginScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtnElem.click();

            MobileElement emailInputElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordInputElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            emailInputElem.sendKeys("teo@sth.com");
            passwordInputElem.sendKeys("12345678");
            loginBtnElem.click();

            //Put the app under test to background in certain time| simulate pressing Home button > relaunch
            //appiumDriver.runAppInBackground(Duration.ofSeconds(3));

            //Put the app under test to background till we call it back
            appiumDriver.runAppInBackground(Duration.ofSeconds(-1));

            //Switch into another app
            appiumDriver.activateApp(AppPackages.SETTINGS);
            By networkLabelSel = MobileBy.xpath("//*[@text='Network & internet']");
            appiumDriver.findElement(networkLabelSel).click();

            By internetLabelSel = MobileBy.xpath("//*[@text='Internet']");
            appiumDriver.findElement(internetLabelSel).click();

            By wifiStatusSel = MobileBy.id("android:id/switch_widget");
            WebDriverWait wait = new WebDriverWait(appiumDriver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(wifiStatusSel));
            MobileElement wifiStatusElem = appiumDriver.findElement(wifiStatusSel);
            String isWifiOn = wifiStatusElem.getAttribute("checked");
            System.out.println(isWifiOn);

            if (isWifiOn.equalsIgnoreCase("true")) wifiStatusElem.click();

            //Come back to the app
            appiumDriver.activateApp(AppPackages.WEBDRIVER_IO);
            appiumDriver.findElement(MobileBy.xpath("//*[@text='OK']")).click();

            //Debug Only
            Thread.sleep(10000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}

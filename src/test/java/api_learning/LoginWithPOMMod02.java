package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.pages.LoginScreenMod01;
import models.pages.LoginScreenMod02;
import platform.Platform;

public class LoginWithPOMMod02 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            MobileElement navLoginScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtnElem.click();

            LoginScreenMod02 loginScreen = new LoginScreenMod02(appiumDriver);
            loginScreen.inputEmailElem("teo@sth.com");
            loginScreen.inputPasswordElem("12345678");
            loginScreen.clickOnLoginBtnElem();
        } catch (Exception e){
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}

package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

public class SwipeVerticallyTest {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            MobileElement navFormScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
            navFormScreenBtnElem.click();

            //Wait until user is on Form screen
            WebDriverWait wait = new WebDriverWait(appiumDriver, 5L);
            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Form Components\")")));

            Swipe swipe = new Swipe(appiumDriver);
            swipe.swipeUp();
            swipe.swipeDown();

            //debug only
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
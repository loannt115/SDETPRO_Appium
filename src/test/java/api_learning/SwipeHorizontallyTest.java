package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.time.Duration;

public class SwipeHorizontallyTest {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            MobileElement navSwipeScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"));
            navSwipeScreenBtnElem.click();

            //Wait until user is on Swipe screen
            WebDriverWait wait = new WebDriverWait(appiumDriver, 5L);
            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Swipe horizontal\")")));

            Swipe swipe = new Swipe(appiumDriver);
            swipe.swipeRightToLeft(50, 3);
            swipe.swipeLeftToRight(50, 2);
            
            //debug only
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
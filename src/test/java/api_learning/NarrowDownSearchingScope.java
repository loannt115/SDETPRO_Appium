package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import platform.Platform;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NarrowDownSearchingScope {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            //Get mobile window size
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            //Calculate touch points
            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;

            int yStartPoint = 0;
            int yEndPoint = 50 * screenHeight / 100;

            //Convert coordinates -> PointOption
            PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

            //Using TouchAction to swipe
            TouchAction touchAction = new TouchAction(appiumDriver);

            //Swipe up
            touchAction
                    .press(startPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000)))
                    .moveTo(endPoint)
                    .release()
                    .perform();

            List<MobileElement> notificationElems = appiumDriver.findElements(MobileBy.id("android:id/status_bar_latest_event_content"));
            Map<String, String> notificationContents = new HashMap<>();
            for (MobileElement notificationElem : notificationElems) {
//                MobileElement appNameElem = notificationElem.findElement(MobileBy.id("android:id/app_name_text"));
                List<MobileElement> titleElems = notificationElem.findElements(MobileBy.id("android:id/title"));
                List<MobileElement> contentElems = notificationElem.findElements(MobileBy.id("android:id/text"));
                if (!titleElems.isEmpty() && !contentElems.isEmpty()) {
                    MobileElement titleElem = titleElems.get(0);
                    MobileElement contentElem = contentElems.get(0);
                    notificationContents.put(titleElem.getText().trim(), contentElem.getText().trim());
                }
            }

            if (notificationContents.keySet().isEmpty())
                throw new RuntimeException("No notification");

            for (String title : notificationContents.keySet()) {
                System.out.println("Title: " + title);
                System.out.println("Content: " + notificationContents.get(title));
            }

            //debug only
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
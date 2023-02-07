package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class Swipe {
    private int screenHeight;
    private int screenWidth;
    private TouchAction touchAction;

    public Swipe(AppiumDriver appiumDriver) {
        this.screenHeight = appiumDriver.manage().window().getSize().getHeight();
        this.screenWidth = appiumDriver.manage().window().getSize().getWidth();
        this.touchAction = new TouchAction(appiumDriver);
    }

    public void swipeUp() {
        //Calculate touch points
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 50 * screenWidth / 100;

        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = 10 * screenHeight / 100;

        //Convert coordinates -> PointOption
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

        //Swipe up
        touchAction
                .press(startPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public void swipeUp(int coordinatePercentStep, int times) {
        //Calculate touch points
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 50 * screenWidth / 100;

        int yStartPoint = coordinatePercentStep * screenHeight / 100;
        int yEndPoint = 0;

        //Convert coordinates -> PointOption
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

        //Swipe up
        for (int time = 0; time < times; time++) {
            touchAction
                    .press(startPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                    .moveTo(endPoint)
                    .release()
                    .perform();
        }
    }

    public void swipeDown() {
        //Calculate touch points
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 50 * screenWidth / 100;

        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = 10 * screenHeight / 100;

        //Convert coordinates -> PointOption
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

        //Swipe down
        touchAction
                .press(endPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                .moveTo(startPoint)
                .release()
                .perform();
    }

    public void swipeRightToLeft(int coordinatePercentStep, int times) {
        //Calculate touch points
        int xStartPoint = coordinatePercentStep * screenWidth / 100;
        int xEndPoint = 0;

        int yStartPoint = 70 * screenHeight / 100;
        int yEndPoint = 70 * screenHeight / 100;

        //Convert coordinates -> PointOption
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

        //Swipe from right to left
        for (int time = 0; time < times; time++) {
            touchAction
                    .press(startPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                    .moveTo(endPoint)
                    .release()
                    .perform();
        }
    }

    public void swipeLeftToRight(int coordinatePercentStep, int times) {
        //Calculate touch points
        int xStartPoint = coordinatePercentStep * screenWidth / 100;
        int xEndPoint = 0;

        int yStartPoint = 70 * screenHeight / 100;
        int yEndPoint = 70 * screenHeight / 100;

        //Convert coordinates -> PointOption
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

        //Swipe from left to right
        for (int time = 0; time < times; time++) {
            touchAction
                    .press(endPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                    .moveTo(startPoint)
                    .release()
                    .perform();
        }
    }

    // TODO: swipe until see an element
    public void swipeUntilISee(String elementString) {
    }
}

package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent;
import models.components.swipe.SwipeComponent;

public class SwipeScreen {
    private final AppiumDriver<MobileElement> appiumDriver;

    public SwipeScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public SwipeComponent swipeComp() {
        return new SwipeComponent(appiumDriver);
    }

    public BottomNavComponent bottomNavComp() {
        return new BottomNavComponent(appiumDriver);
    }
}

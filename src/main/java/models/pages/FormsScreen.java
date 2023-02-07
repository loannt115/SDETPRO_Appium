package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.forms.FormsComponent;
import models.components.global.BottomNavComponent;

public class FormsScreen {
    private final AppiumDriver<MobileElement> appiumDriver;

    public FormsScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public FormsComponent formsComp() {
        return new FormsComponent(appiumDriver);
    }

    public BottomNavComponent bottomNavComp() {
        return new BottomNavComponent(appiumDriver);
    }
}

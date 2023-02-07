package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent;
import models.components.webview.WebViewComponent;

public class WebViewScreen {
    private final AppiumDriver<MobileElement> appiumDriver;

    public WebViewScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public WebViewComponent loginFormComp() {
        return new WebViewComponent(appiumDriver);
    }

    public BottomNavComponent bottomNavComp() {
        return new BottomNavComponent(appiumDriver);
    }
}

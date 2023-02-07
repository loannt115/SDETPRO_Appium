package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.HomeScreen;

public class BaseFlow {
    protected final AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void goToHomeScreen() {
        new HomeScreen(appiumDriver).bottomNavComp().clickOnHomeIcon();
    }

    public void goToWebviewScreen() {
        new HomeScreen(appiumDriver).bottomNavComp().clickOnWebviewIcon();
    }

    public void goToLoginScreen() {
        new HomeScreen(appiumDriver).bottomNavComp().clickOnLoginIcon();
    }

    public void goToFormsScreen() {
        new HomeScreen(appiumDriver).bottomNavComp().clickOnFormsIcon();
    }

    public void goToSwipeScreen() {
        new HomeScreen(appiumDriver).bottomNavComp().clickOnSwipeIcon();
    }
}

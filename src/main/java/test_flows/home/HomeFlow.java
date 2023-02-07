package test_flows.home;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import models.components.home.HomeComponent;
import models.pages.HomeScreen;
import org.testng.Assert;
import test_flows.BaseFlow;

public class HomeFlow extends BaseFlow {

    public HomeFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    @Step("Verify app purpose text and support text")
    public void verifyHomeScreen() {
        HomeScreen homeScreen = new HomeScreen(appiumDriver);
        HomeComponent homeComp = homeScreen.homeComp();
        String actualAppPurposeTxt = homeComp.getAppPurposeTxt();
        String expectedAppPurposeTxt = "Demo app for the appium-boilerplate";
        String actualSupportTxt = homeComp.getSupportTxt();
        String expectedSupportTxt = "Support";

        Assert.assertEquals(actualAppPurposeTxt, expectedAppPurposeTxt, "[ERR] App purpose text is not correct!");
        Assert.assertEquals(actualSupportTxt, expectedSupportTxt, "[ERR] Support text is not correct!");
    }
}

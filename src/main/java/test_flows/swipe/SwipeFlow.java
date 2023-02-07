package test_flows.swipe;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import models.components.swipe.SwipeComponent;
import models.pages.SwipeScreen;
import org.testng.Assert;
import test_flows.BaseFlow;

public class SwipeFlow extends BaseFlow {

    public SwipeFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    @Step("Verify FullOpenSource carousel content")
    public void verifyFullOpenSourceCarousel() {
        SwipeScreen swipeScreen = new SwipeScreen(appiumDriver);
        SwipeComponent swipeComp = swipeScreen.swipeComp();
        swipeComp.waitSwipeScreenDisplay();

        Boolean isFullOpenSourceCarouselTitleDisplay = swipeComp.fullOpenSourceCarouselTitleElem().isDisplayed();
        Assert.assertTrue(isFullOpenSourceCarouselTitleDisplay, "[ERR] FullOpenSourceCarouselTitle is not displayed");

        Boolean isFullOpenSourceCarouselContentDisplay = swipeComp.fullOpenSourceCarouselContentElem().isDisplayed();
        Assert.assertTrue(isFullOpenSourceCarouselContentDisplay, "[ERR] FullOpenSourceCarouselContent is not displayed");
    }

    @Step("Verify GreatCommunity carousel content")
    public void verifyGreatCommunityCarousel() {
        SwipeScreen swipeScreen = new SwipeScreen(appiumDriver);
        SwipeComponent swipeComp = swipeScreen.swipeComp();

        Boolean isGreatCommunityCarouselTitleDisplay = swipeComp.greatCommunityCarouselTitleElem().isDisplayed();
        Assert.assertTrue(isGreatCommunityCarouselTitleDisplay, "[ERR] GreatCommunityCarouselTitle is not displayed");

        Boolean isGreatCommunityCarouselContentDisplay = swipeComp.greatCommunityCarouselContentElem().isDisplayed();
        Assert.assertTrue(isGreatCommunityCarouselContentDisplay, "[ERR] GreatCommunityCarouselContent is not displayed");
    }

    @Step("Verify JsFoundation carousel content")
    public void verifyJsFoundationCarousel() {
        SwipeScreen swipeScreen = new SwipeScreen(appiumDriver);
        SwipeComponent swipeComp = swipeScreen.swipeComp();

        Boolean isJsFoundationCarouselTitleDisplay = swipeComp.jsFoundationCarouselTitleElem().isDisplayed();
        Assert.assertTrue(isJsFoundationCarouselTitleDisplay, "[ERR] JsFoundationCarouselTitle is not displayed");

        Boolean isJsFoundationCarouselContentDisplay = swipeComp.jsFoundationCarouselContentElem().isDisplayed();
        Assert.assertTrue(isJsFoundationCarouselContentDisplay, "[ERR] JsFoundationCarouselContent is not displayed");
    }

    @Step("Verify SupportVideo carousel content")
    public void verifySupportVideoCarousel() {
        SwipeScreen swipeScreen = new SwipeScreen(appiumDriver);
        SwipeComponent swipeComp = swipeScreen.swipeComp();

        Boolean isSupportVideoCarouselTitleDisplay = swipeComp.supportVideoCarouselTitleElem().isDisplayed();
        Assert.assertTrue(isSupportVideoCarouselTitleDisplay, "[ERR] SupportVideoCarouselTitle is not displayed");

        Boolean isSupportVideoCarouselContentDisplay = swipeComp.supportVideoCarouselContentElem().isDisplayed();
        Assert.assertTrue(isSupportVideoCarouselContentDisplay, "[ERR] SupportVideoCarouselContent is not displayed");
    }

    @Step("Verify Extendable carousel content")
    public void verifyExtendableCarousel() {
        SwipeScreen swipeScreen = new SwipeScreen(appiumDriver);
        SwipeComponent swipeComp = swipeScreen.swipeComp();

        Boolean isExtendableCarouselTitleDisplay = swipeComp.extendableCarouselTitleElem().isDisplayed();
        Assert.assertTrue(isExtendableCarouselTitleDisplay, "[ERR] ExtendableCarouselTitle is not displayed");

        Boolean isExtendableCarouselContentDisplay = swipeComp.extendableCarouselContentElem().isDisplayed();
        Assert.assertTrue(isExtendableCarouselContentDisplay, "[ERR] ExtendableCarouselContent is not displayed");
    }

    @Step("Verify Compatible carousel content")
    public void verifyCompatibleCarouse() {
        SwipeScreen swipeScreen = new SwipeScreen(appiumDriver);
        SwipeComponent swipeComp = swipeScreen.swipeComp();

        Boolean isCompatibleCarouselTitleDisplay = swipeComp.compatibleCarouselTitleElem().isDisplayed();
        Assert.assertTrue(isCompatibleCarouselTitleDisplay, "[ERR] iCompatibleCarouselTitle is not displayed");

        Boolean isCompatibleCarouselContentDisplay = swipeComp.compatibleCarouselContentElem().isDisplayed();
        Assert.assertTrue(isCompatibleCarouselContentDisplay, "[ERR] CompatibleCarouselContent is not displayed");
    }

    @Step("Verify WebdriverIO logo founded at the end")
    public void verifyLogoAtTheEnd() {
        SwipeScreen swipeScreen = new SwipeScreen(appiumDriver);
        SwipeComponent swipeComp = swipeScreen.swipeComp();

        Boolean isWebDriverIOLogoDisplay = swipeComp.webDriverIOLogoElem().isDisplayed();
        Assert.assertTrue(isWebDriverIOLogoDisplay, "[ERR] WebDriverIOLogo is not displayed");


        Boolean isFoundMeTextDisplay = swipeComp.foundMeTextElem().isDisplayed();
        Assert.assertTrue(isFoundMeTextDisplay, "[ERR] Found me text is not displayed");
    }
}

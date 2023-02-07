package models.components.swipe;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwipeComponent {
    private final AppiumDriver<MobileElement> appiumDriver;
    private final By swipeScreenTitleSel = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Swipe horizontal\")");
    private final By fullOpenSourceCarouselTitleSel = MobileBy.xpath("//*[contains(@text, 'FULLY OPEN SOURCE')]");
    private final By fullOpenSourceCarouselContentSel = MobileBy.xpath("//*[contains(@text, 'WebdriverIO is fully open source and can be found on GitHub')]");
    private final By greatCommunityCarouselTitleSel = MobileBy.xpath("//*[contains(@text, 'GREAT COMMUNITY')]");
    private final By greatCommunityCarouselContentSel = MobileBy.xpath("//*[contains(@text, 'WebdriverIO has a great community that supports all members.')]");
    private final By jsFoundationCarouselTitleSel = MobileBy.xpath("//*[contains(@text, 'JS.FOUNDATION')]");
    private final By jsFoundationCarouselContentSel = MobileBy.xpath("//*[contains(@text, 'The JS Foundation is host to projects that span the entire JavaScript ecosystem.')]");
    private final By supportVideoCarouselTitleSel = MobileBy.xpath("//*[contains(@text, 'SUPPORT VIDEOS')]");
    private final By supportVideoCarouselContentSel = MobileBy.xpath("//*[contains(@text, 'The community around WebdriverIO is actively speaking on various user groups or conferences about specific topics around automated testing with WebdriverIO.')]");
    private final By extendableCarouselTitleSel = MobileBy.xpath("//*[contains(@text, 'EXTENDABLE')]");
    private final By extendableCarouselContentSel = MobileBy.xpath("//*[contains(@text, 'Adding helper functions, or more complicated sets and combinations of existing commands is simple and really useful')]");
    private final By compatibleCarouselTitleSel = MobileBy.xpath("//*[contains(@text, 'COMPATIBLE')]");
    private final By compatibleCarouselContentSel = MobileBy.xpath("//*[contains(@text, 'WebdriverIO works in combination with most of the TDD and BDD test frameworks in the JavaScript world')]");
    private final By webDriverIOLogoSel = MobileBy.AccessibilityId("WebdriverIO logo");
    private final By foundMeTextSel = MobileBy.xpath("//*[contains(@text, 'You found me!!!')]");

    public SwipeComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Step("Wait for Swipe screen display")
    public void waitSwipeScreenDisplay() {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(swipeScreenTitleSel));
    }

    public MobileElement fullOpenSourceCarouselTitleElem() {
        return appiumDriver.findElement(fullOpenSourceCarouselTitleSel);
    }

    public MobileElement fullOpenSourceCarouselContentElem() {
        return appiumDriver.findElement(fullOpenSourceCarouselContentSel);
    }

    public MobileElement greatCommunityCarouselTitleElem() {
        return appiumDriver.findElement(greatCommunityCarouselTitleSel);
    }

    public MobileElement greatCommunityCarouselContentElem() {
        return appiumDriver.findElement(greatCommunityCarouselContentSel);
    }

    public MobileElement jsFoundationCarouselTitleElem() {
        return appiumDriver.findElement(jsFoundationCarouselTitleSel);
    }

    public MobileElement jsFoundationCarouselContentElem() {
        return appiumDriver.findElement(jsFoundationCarouselContentSel);
    }

    public MobileElement supportVideoCarouselTitleElem() {
        return appiumDriver.findElement(supportVideoCarouselTitleSel);
    }

    public MobileElement supportVideoCarouselContentElem() {
        return appiumDriver.findElement(supportVideoCarouselContentSel);
    }

    public MobileElement extendableCarouselTitleElem() {
        return appiumDriver.findElement(extendableCarouselTitleSel);
    }

    public MobileElement extendableCarouselContentElem() {
        return appiumDriver.findElement(extendableCarouselContentSel);
    }

    public MobileElement compatibleCarouselTitleElem() {
        return appiumDriver.findElement(compatibleCarouselTitleSel);
    }

    public MobileElement compatibleCarouselContentElem() {
        return appiumDriver.findElement(compatibleCarouselContentSel);
    }

    public MobileElement webDriverIOLogoElem() {
        return appiumDriver.findElement(webDriverIOLogoSel);
    }

    public MobileElement foundMeTextElem() {
        return appiumDriver.findElement(foundMeTextSel);
    }
}

package test_flows.webview;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import models.components.webview.WebViewComponent;
import models.pages.WebViewScreen;
import org.testng.Assert;
import test_flows.BaseFlow;

public class WebViewFlow extends BaseFlow {
    public WebViewFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void switchToWebViewContext(){
        WebViewScreen webViewScreen = new WebViewScreen(appiumDriver);
        WebViewComponent webViewComp = webViewScreen.loginFormComp();

        webViewComp.switchToWebViewContext();
    }

    public void clickOnMenuBtn(){
        WebViewScreen webViewScreen = new WebViewScreen(appiumDriver);
        WebViewComponent webViewComp = webViewScreen.loginFormComp();

        webViewComp.clickOnMenuBtn();
    }

    @Step("Verify menu text and hyperlink")
    public void verifyMenu(){
        WebViewScreen webViewScreen = new WebViewScreen(appiumDriver);
        WebViewComponent webViewComp = webViewScreen.loginFormComp();

        String actualDocsMenuLink = webViewComp.getDocsMenuHyperlink();
        String expectedDocsMenuLink = "/docs/gettingstarted";
        Assert.assertEquals(actualDocsMenuLink, expectedDocsMenuLink, "[ERR] Docs menu link is not correct");

        String actualApiMenuLink = webViewComp.getAPIMenuHyperlink();
        String expectedApiMenuLink = "/docs/api";
        Assert.assertEquals(actualApiMenuLink, expectedApiMenuLink, "[ERR] API menu link is not correct");

        String actualBlogMenuLink = webViewComp.getBlogMenuHyperlink();
        String expectedBlogMenuLink = "/blog";
        Assert.assertEquals(actualBlogMenuLink, expectedBlogMenuLink, "[ERR] Blog menu link is not correct");

        String actualContributeMenuLink = webViewComp.getContributeMenuHyperlink();
        String expectedContributeMenuLink = "/docs/contribute";
        Assert.assertEquals(actualContributeMenuLink, expectedContributeMenuLink, "[ERR] Contribute menu link is not correct");

        String actualCommunityMenuLink = webViewComp.getCommunityMenuHyperlink();
        String expectedCommunityMenuLink = "/community/support";
        Assert.assertEquals(actualCommunityMenuLink, expectedCommunityMenuLink, "[ERR] Community menu link is not correct");

        String actualVersionMenuLink = webViewComp.getVersionMenuHyperlink();
        String expectedVersionMenuLink = "/versions";
        Assert.assertEquals(actualVersionMenuLink, expectedVersionMenuLink, "[ERR] Version menu link is not correct");

        String actualGitMenuLink = webViewComp.getGitMenuHyperlink();
        String expectedGitMenuLink = "https://github.com/webdriverio/webdriverio";
        Assert.assertEquals(actualGitMenuLink, expectedGitMenuLink, "[ERR] Git menu link is not correct");

        String actualTwitterMenuLink = webViewComp.getTwitterMenuHyperlink();
        String expectedTwitterMenuLink = "https://twitter.com/webdriverio";
        Assert.assertEquals(actualTwitterMenuLink, expectedTwitterMenuLink, "[ERR] Twitter menu link is not correct");
    }
}

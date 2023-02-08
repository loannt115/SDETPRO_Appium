package models.components.webview;

import context.Contexts;
import context.WaitMoreThanOneContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebViewComponent {
    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By navToggleBtnSel = By.cssSelector(".navbar__toggle");
    private final static By menuSideBarSel = By.cssSelector(".navbar-sidebar");
    private final static By docsMenuSel = By.xpath("//a[contains(text(), 'Docs')]");
    private final static By apiMenuSel = By.xpath("//a[contains(text(), 'API')]");
    private final static By blogMenuSel = By.xpath("//a[contains(text(), 'Blog')]");
    private final static By contributeMenuSel = By.xpath("//a[contains(text(), 'Contribute')]");
    private final static By communityMenuSel = By.xpath("//a[contains(text(), 'Community')]");
    private final static By versionMenuSel = By.xpath("//a[contains(text(), 'v8')]");
    private final static By githubMenuSel = By.cssSelector("a[href*='github']");
    private final static By twitterMenuSel = By.cssSelector("a[href*='twitter']");

    public WebViewComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Step("Switch to WebView context")
    public void switchToWebViewContext(){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 15L);
        wait.until(new WaitMoreThanOneContext(appiumDriver));
        for (String contextHandle : appiumDriver.getContextHandles()) {
            System.out.println(contextHandle);
        }
        appiumDriver.context(Contexts.WEB_VIEW);
        wait.until(ExpectedConditions.visibilityOfElementLocated(navToggleBtnSel));
    }

    @Step("Switch to Native context")
    public void switchToNativeContext(){
        appiumDriver.context(Contexts.NATIVE);
    }

    @Step("Click on navigation menu button")
    public void clickOnMenuBtn(){
        appiumDriver.findElement(navToggleBtnSel).click();
        WebDriverWait wait = new WebDriverWait(appiumDriver, 15L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuSideBarSel));
    }

    public WebElement menuSideBarElem(){
        return appiumDriver.findElement(menuSideBarSel);
    }

    public String getDocsMenuHyperlink(){
        return menuSideBarElem().findElement(docsMenuSel).getAttribute("href").trim();
    }

    public String getAPIMenuHyperlink(){
        return menuSideBarElem().findElement(apiMenuSel).getAttribute("href").trim();
    }

    public String getBlogMenuHyperlink(){
        return menuSideBarElem().findElement(blogMenuSel).getAttribute("href").trim();
    }

    public String getContributeMenuHyperlink(){
        return menuSideBarElem().findElement(contributeMenuSel).getAttribute("href").trim();
    }

    public String getCommunityMenuHyperlink(){
        return menuSideBarElem().findElement(communityMenuSel).getAttribute("href").trim();
    }

    public String getVersionMenuHyperlink(){
        return menuSideBarElem().findElement(versionMenuSel).getAttribute("href").trim();
    }

    public String getGitMenuHyperlink(){
        return menuSideBarElem().findElement(githubMenuSel).getAttribute("href").trim();
    }

    public String getTwitterMenuHyperlink(){
        return menuSideBarElem().findElement(twitterMenuSel).getAttribute("href").trim();
    }
}

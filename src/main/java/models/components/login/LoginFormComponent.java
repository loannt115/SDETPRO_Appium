package models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginFormComponent {
    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By emailSel = MobileBy.AccessibilityId("input-email");
    private final static By passwordSel = MobileBy.AccessibilityId("input-password");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");
    private final static By loginSuccessTitleSel = MobileBy.id("android:id/alertTitle");
    private final static By loginSuccessMessageSel = MobileBy.id("android:id/message");
    private final static By loginSuccessOKButtonSel = MobileBy.id("android:id/button1");

    public LoginFormComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
    }

    @Step("Input email as {emailTxt}")
    public void inputEmail(String emailTxt) {
        if (!emailTxt.isEmpty()) {
            MobileElement emailElem = appiumDriver.findElement(emailSel);
            emailElem.clear();
            emailElem.sendKeys(emailTxt);
        }
    }

    @AndroidFindBy(xpath = "//*[contains(@text, 'Please enter a valid email address')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Please enter a valid email address\"")
    private MobileElement incorrectEmailTextElem;

    @Step("Get invalid email string")
    public String getInvalidEmailStr() {
        return incorrectEmailTextElem.getText().trim();
    }

    @Step("Input password as {passwordTxt}")
    public void inputPassword(String passwordTxt) {
        if (!passwordTxt.isEmpty()) {
            MobileElement passwordElem = appiumDriver.findElement(passwordSel);
            passwordElem.clear();
            passwordElem.sendKeys(passwordTxt);
        }
    }

    @AndroidFindBy(xpath = "//*[contains(@text, 'Please enter at least 8 characters')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Please enter at least 8 characters\"")
    private MobileElement incorrectPasswordTextElem;

    @Step("Get invalid password string")
    public String getInvalidPasswordStr() {
        return incorrectPasswordTextElem.getText().trim();
    }

    @Step("Click on Login button")
    public void clickOnLoginBtn() {
        appiumDriver.findElement(loginBtnSel).click();
    }

    @Step("Get login success title")
    public String getLoginSuccessTitleStr() {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginSuccessTitleSel));
        return appiumDriver.findElement(loginSuccessTitleSel).getText().trim();
    }

    @Step("Get login success message")
    public String getLoginSuccessMessageStr() {
        return appiumDriver.findElement(loginSuccessMessageSel).getText().trim();
    }

    @Step("Get login success OK btn name")
    public String getLoginSuccessOKBtnStr() {
        return appiumDriver.findElement(loginSuccessOKButtonSel).getText().trim();
    }

    @Step("Click on OK btn on login success pop-up")
    public void clickOnOKBtnOnSuccessPopup() {
        appiumDriver.findElement(loginSuccessOKButtonSel).click();
    }
}

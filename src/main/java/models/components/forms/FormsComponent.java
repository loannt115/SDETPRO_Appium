package models.components.forms;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormsComponent {
    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By formScreenTitleSel = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Form Components\")");
    private final static By inputFieldSel = MobileBy.AccessibilityId("text-input");
    private final static By inputTextResultSel = MobileBy.AccessibilityId("input-text-result");
    private final static By switchSel = MobileBy.AccessibilityId("switch");
    private final static By switchTextSel = MobileBy.AccessibilityId("switch-text");
    private final static By dropdownSel = MobileBy.AccessibilityId("Dropdown");
    private final static By dropdownOption1Sel = MobileBy.xpath("//*[contains(@text, 'webdriver.io is awesome')]");
    private final static By dropdownOption2Sel = MobileBy.xpath("//*[contains(@text, 'Appium is awesome')]");
    private final static By dropdownOption3Sel = MobileBy.xpath("//*[contains(@text, 'This app is awesome')]");
    private final static By activeBtnSel = MobileBy.AccessibilityId("button-Active");
    private final static By activePopupTitleSel = MobileBy.id("android:id/alertTitle");
    private final static By activePopupMessageSel = MobileBy.id("android:id/message");
    private final static By activePopupOKBtnSel = MobileBy.id("android:id/button1");
    private final static By inactiveBtnSel = MobileBy.AccessibilityId("button-Inactive");

    public FormsComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Step("Wait for Form screen display")
    public void waitFormScreenDisplay() {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(formScreenTitleSel));
    }


    @Step("Input text as {text} on Input field")
    public void inputText(String text) {
        if (!text.isEmpty()) {
            MobileElement inputFieldElem = appiumDriver.findElement(inputFieldSel);
            inputFieldElem.clear();
            inputFieldElem.sendKeys(text);
        }
    }

    @Step("Get input text result")
    public String getInputFieldResult() {
        return appiumDriver.findElement(inputTextResultSel).getText().trim();
    }

    @Step("Click on Switch toggle")
    public void clickOnSwitchToggle() {
        appiumDriver.findElement(switchSel).click();
    }

    @Step("Get Switch toggle status")
    public String  getSwitchStatusText() {
        return appiumDriver.findElement(switchTextSel).getText().trim();
    }

    @Step("Select option webdriver.io is awesome")
    public void selectDropdownOption1() {
        appiumDriver.findElement(dropdownSel).click();
        appiumDriver.findElement(dropdownOption1Sel).click();
    }

    @Step("Select option Appium is awesome")
    public void selectDropdownOption2() {
        appiumDriver.findElement(dropdownSel).click();
        appiumDriver.findElement(dropdownOption2Sel).click();
    }

    @Step("Select option This app is awesome")
    public void selectDropdownOption3() {
        appiumDriver.findElement(dropdownSel).click();
        appiumDriver.findElement(dropdownOption3Sel).click();
    }

    @Step("Click on Active btn")
    public void clickOnActiveBtn() {
        appiumDriver.findElement(activeBtnSel).click();
    }

    public String getMessageOnActivePopup() {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(activePopupTitleSel));
        return appiumDriver.findElement(activePopupMessageSel).getText().trim();
    }

    @Step("Click on OK btn on active pop-up")
    public void clickOnOKBtn() {
        appiumDriver.findElement(activePopupOKBtnSel).click();
    }

    public MobileElement inactiveBtnElem() {
        return appiumDriver.findElement(inactiveBtnSel);
    }
}

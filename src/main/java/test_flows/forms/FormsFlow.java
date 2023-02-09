package test_flows.forms;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import models.components.forms.FormsComponent;
import models.pages.FormsScreen;
import org.testng.Assert;
import test_flows.BaseFlow;

public class FormsFlow extends BaseFlow {
    private FormsComponent formsComp;

    public FormsFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        this.formsComp = new FormsScreen(appiumDriver).formsComp();
    }

    @Step("Verify what user input can be displayed")
    public void verifyInputField(String inputtedText){
        formsComp.waitFormScreenDisplay();
        if (inputtedText.isEmpty()){
            Assert.assertEquals(formsComp.getInputFieldResult(), null);
        } else {
            formsComp.inputText(inputtedText);
            String actualInputTextResult = formsComp.getInputFieldResult();
            Assert.assertEquals(actualInputTextResult, inputtedText);
        }
    }

    @Step("Verify user can switch on/off and text displayed")
    public void verifySwitchToggle(){
        String switchStatusOn = "Click to turn the switch ON";
        String switchStatusOff = "Click to turn the switch OFF";
        String currentSwitchStatus = formsComp.getSwitchStatusText();

        formsComp.clickOnSwitchToggle();
        String actualSwitchStatus = formsComp.getSwitchStatusText();
        if (currentSwitchStatus == switchStatusOn){
            Assert.assertEquals(actualSwitchStatus, switchStatusOff, "[ERR] Switch toggle status is not correct!");
        } else if (currentSwitchStatus == switchStatusOff){
            Assert.assertEquals(actualSwitchStatus, switchStatusOn, "[ERR] Switch toggle status is not correct!");
        }
    }

    @Step("User can select dropdown webdriverio/appium/this app is awesome")
    public void selectDropdown(){
        formsComp.selectDropdownOption1();
        formsComp.selectDropdownOption2();
        formsComp.selectDropdownOption3();
    }

    @Step("Verify Active button works properly")
    public void verifyActiveBtn(){
        formsComp.clickOnActiveBtn();
        String actualMessageOnActivePopup = formsComp.getMessageOnActivePopup();
        String expectedMessageOnActivePopup = "This button is active";

        Assert.assertEquals(actualMessageOnActivePopup, expectedMessageOnActivePopup, "[ERR] Active message is correct");
        formsComp.clickOnOKBtn();

        Boolean isInactiveBtn = formsComp.inactiveBtnElem().isEnabled();
        Assert.assertTrue(isInactiveBtn, "[ERR] Inactive button is not disable");
    }

    @Step("Verify Inactive button works properly")
    public void verifyInactiveBtn(){
        Boolean isInactiveBtn = formsComp.inactiveBtnElem().isEnabled();
        Assert.assertTrue(isInactiveBtn, "[ERR] Inactive button is not disable");
    }
}

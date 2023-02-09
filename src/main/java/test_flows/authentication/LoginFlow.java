package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import models.components.login.LoginFormComponent;
import models.pages.LoginScreen;
import org.apache.commons.validator.routines.EmailValidator;
import org.testng.Assert;
import test_flows.BaseFlow;

public class LoginFlow extends BaseFlow {
    private String email;
    private String password;
    private LoginFormComponent loginFormComp;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String email, String password) {
        super(appiumDriver);
        this.email = email;
        this.password = password;
        this.loginFormComp = new LoginScreen(appiumDriver).loginFormComp();
    }

    @Step("Login")
    public void login() {
        if (!email.isEmpty()) {
            loginFormComp.inputEmail(email);
        }

        if (!password.isEmpty()) {
            loginFormComp.inputPassword(password);
        }

        loginFormComp.clickOnLoginBtn();
    }

    @Step("Verify login")
    public void verifyLogin() {
        boolean isEmailValid = EmailValidator.getInstance().isValid(email);
        boolean isPasswordValid = password.length() >= 8;

        if (isEmailValid && isPasswordValid) {
            verifyCorrectLoginCreds(loginFormComp);
        }

        if (!isEmailValid) {
            verifyIncorrectEmail(loginFormComp);
        }

        if (!isPasswordValid) {
            verifyIncorrectPassword(loginFormComp);
        }
    }

    @Step("Verify login with correct creds")
    private void verifyCorrectLoginCreds(LoginFormComponent loginFormComp) {
        String actualLoginSuccessTitleStr = loginFormComp.getLoginSuccessTitleStr();
        String expectedLoginSuccessTitleStr = "Success";
        String actualLoginSuccessMessageStr = loginFormComp.getLoginSuccessMessageStr();
        String expectedLoginSuccessMessageStr = "You are logged in!";
        String actualLoginSuccessOKBtnName = loginFormComp.getLoginSuccessOKBtnStr();
        String expectedLoginSuccessOKBtnName = "OK";

        Assert.assertEquals(actualLoginSuccessTitleStr, expectedLoginSuccessTitleStr, "[ERR] Login success pop-up - Title is not correct!");
        Assert.assertEquals(actualLoginSuccessMessageStr, expectedLoginSuccessMessageStr, "[ERR] Login success pop-up - Message is not correct!");
        Assert.assertEquals(actualLoginSuccessOKBtnName, expectedLoginSuccessOKBtnName, "[ERR] Login success pop-up - OK button name is not correct!");

        loginFormComp.clickOnOKBtnOnSuccessPopup();
    }

    @Step("Verify login with incorrect email")
    private void verifyIncorrectEmail(LoginFormComponent loginFormComp) {
        String actualInvalidEmailStr = loginFormComp.getInvalidEmailStr();
        String expectedInvalidEmailStr = "Please enter a valid email address";

        Assert.assertEquals(actualInvalidEmailStr, expectedInvalidEmailStr, "[ERR] Message is not correct");
    }

    @Step("Verify login with incorrect password")
    private void verifyIncorrectPassword(LoginFormComponent loginFormComp) {
        String actualInvalidPasswordStr = loginFormComp.getInvalidPasswordStr();
        String expectedInvalidPasswordStr = "Please enter at least 8 characters";

        Assert.assertEquals(actualInvalidPasswordStr, expectedInvalidPasswordStr, "[ERR] Message is not correct");
    }
}

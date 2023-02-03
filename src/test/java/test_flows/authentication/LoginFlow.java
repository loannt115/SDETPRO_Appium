package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import models.components.global.BottomNavComponent;
import models.components.login.LoginFormComponent;
import models.pages.LoginScreen;
import org.apache.commons.validator.routines.EmailValidator;
import org.testng.Assert;
import test_flows.BaseFlow;

public class LoginFlow extends BaseFlow {
    private String email;
    private String password;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String email, String password) {
        super(appiumDriver);
        this.email = email;
        this.password = password;
    }

    public void login(){
        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComponent loginFormComp = loginScreen.loginFormComp();

        if (!email.isEmpty()) {
            loginFormComp.inputEmail(email);
        }

        if (!password.isEmpty()){
            loginFormComp.inputPassword(password);
        }

        loginFormComp.clickOnLoginBtn();
    }

    public void verifyLogin(){
        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComponent loginFormComp = loginScreen.loginFormComp();
        boolean isEmailValid = EmailValidator.getInstance().isValid(email);
        boolean isPasswordValid = password.length() >= 8;

        if (isEmailValid && isPasswordValid){
            verifyCorrectLoginCreds();
        }

        if (!isEmailValid){
            verifyIncorrectEmail(loginFormComp);
        }

        if (!isPasswordValid){
            verifyIncorrectPassword(loginFormComp);
        }
    }

    //Todo: homework
    @Step("Verify login with correct creds")
    private void verifyCorrectLoginCreds() {
        System.out.println("verify correct login creds");
    }

    @Step("Verify login with incorrect email")
    private void verifyIncorrectEmail(LoginFormComponent loginFormComp) {
        String actualInvalidEmailStr = loginFormComp.getInvalidEmailStr();
        String expectedInvalidEmailStr = "Please enter a valid email address1";

        Assert.assertEquals(actualInvalidEmailStr, expectedInvalidEmailStr, "[ERR] Message is not correct");
    }

    @Step("Verify login with incorrect password")
    private void verifyIncorrectPassword(LoginFormComponent loginFormComp) {
        String actualInvalidPasswordStr = loginFormComp.getInvalidPasswordStr();
        String expectedInvalidPasswordStr = "Please enter at least 8 characters";

        Assert.assertEquals(actualInvalidPasswordStr, expectedInvalidPasswordStr, "[ERR] Message is not correct");
    }
}

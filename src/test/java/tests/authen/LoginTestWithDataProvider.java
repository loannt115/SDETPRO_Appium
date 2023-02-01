package tests.authen;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import platform.Platform;
import test_flows.authentication.LoginFlow;

public class LoginTestWithDataProvider {
    @Test(dataProvider = "loginCredData")
    public void testLogin(LoginTest.LoginCred loginCred) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            LoginFlow loginFlow = new LoginFlow(appiumDriver, loginCred.getEmail(), loginCred.getPassword());
            loginFlow.goToLoginScreen();
            loginFlow.login();
            loginFlow.verifyLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }

    @DataProvider
    public LoginTest.LoginCred[] loginCredData() {
        LoginTest.LoginCred loginCred01 = new LoginTest.LoginCred("teo@", "12345678");
        LoginTest.LoginCred loginCred02 = new LoginTest.LoginCred("teo@sth.com", "1234567");
        LoginTest.LoginCred loginCred03 = new LoginTest.LoginCred("teo@sth.com", "12345678");
        return new LoginTest.LoginCred[]{loginCred01, loginCred02, loginCred03};
    }
}

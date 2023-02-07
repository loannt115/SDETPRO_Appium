package models.components.home;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class HomeComponent {
    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By appPurposeTxtSel = MobileBy.xpath("//android.widget.TextView[contains(@text, \"Demo app for\")]");
    private final static By supportTxtSel = MobileBy.xpath("//android.widget.TextView[contains(@text, \"Support\")]");

    public HomeComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public String getAppPurposeTxt() {
        return appiumDriver.findElement(appPurposeTxtSel).getText().trim();
    }

    public String getSupportTxt() {
        return appiumDriver.findElement(supportTxtSel).getText().trim();
    }
}

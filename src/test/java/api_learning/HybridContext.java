package api_learning;

import context.Contexts;
import context.WaitMoreThanOneContext;
import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HybridContext {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {
            By webviewNavBtnSel = MobileBy.AccessibilityId("Webview");
            MobileElement webviewNavBtnElem = appiumDriver.findElement(webviewNavBtnSel);
            webviewNavBtnElem.click();

            //Wait until we have one more than context
            WebDriverWait wait = new WebDriverWait(appiumDriver, 15L);
            wait.until(new WaitMoreThanOneContext(appiumDriver));

            for (String contextHandle : appiumDriver.getContextHandles()) {
                System.out.println(contextHandle);
            }

            appiumDriver.context(Contexts.WEB_VIEW);
            WebElement navToggleBtnElem = appiumDriver.findElementByCssSelector(".navbar__toggle");
            navToggleBtnElem.click();
            List<MobileElement> menuItemsElem = appiumDriver.findElementsByCssSelector(".menu__list li a");
            Map<String, String> menuItemDataMap = new HashMap<>();
            List<MenuItemData> menuItemDataList = new ArrayList<>();

            if (menuItemsElem.isEmpty()) throw new RuntimeException("[ERR] There is no list items!");
            for (MobileElement menuItemElem : menuItemsElem) {
                String itemText = menuItemElem.getText();
                String itemHref = menuItemElem.getAttribute("href");
                if (itemText.isEmpty()) {
                    if (menuItemElem.getAttribute("href").contains("github")) {
                        menuItemDataMap.put("Github", itemHref);
                        menuItemDataList.add(new MenuItemData("Github", itemHref));
                    } else if (menuItemElem.getAttribute("href").contains("twitter")) {
                        menuItemDataMap.put("Twitter", itemHref);
                        menuItemDataList.add(new MenuItemData("Twitter", itemHref));
                    } else {
                        menuItemDataMap.put("Other", itemHref);
                        menuItemDataList.add(new MenuItemData("Other", itemHref));
                    }
                } else {
                    menuItemDataMap.put(itemText, itemHref);
                    menuItemDataList.add(new MenuItemData(itemText, itemHref));
                }
            }

            for (String itemText : menuItemDataMap.keySet()) {
                System.out.println("item Text: " + itemText);
                System.out.println("item Href: " + menuItemDataMap.get(itemText));
            }

            for (MenuItemData menuItemData : menuItemDataList) {
                System.out.println(menuItemData);
            }

            appiumDriver.context(Contexts.NATIVE);

            //Debug only
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }

    public static class MenuItemData{
        private String name;
        private String href;

        public MenuItemData(String name, String href) {
            this.name = name;
            this.href = href;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        @Override
        public String toString() {
            return "MenuItemData{" +
                    "name='" + name + '\'' +
                    ", href='" + href + '\'' +
                    '}';
        }
    }
}

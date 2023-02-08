package tests.webview;

import org.testng.annotations.Test;
import test_flows.webview.WebViewFlow;
import tests.BaseTest;

public class WebViewTest extends BaseTest {
    @Test
    public void testWebView(){
        WebViewFlow webViewFlow = new WebViewFlow(getDriver());
        webViewFlow.goToWebviewScreen();
        webViewFlow.switchToWebViewContext();
        webViewFlow.clickOnMenuBtn();
        webViewFlow.verifyMenu();
        webViewFlow.switchToNativeContext();
    }
}

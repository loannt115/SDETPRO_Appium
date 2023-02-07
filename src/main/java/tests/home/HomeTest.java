package tests.home;

import org.testng.annotations.Test;
import test_flows.home.HomeFlow;
import tests.BaseTest;

public class HomeTest extends BaseTest {
    @Test
    public void testHome() {
        HomeFlow homeFlow = new HomeFlow(getDriver());
        homeFlow.goToHomeScreen();
        homeFlow.verifyHomeScreen();
    }
}

package tests.forms;

import org.testng.annotations.Test;
import test_flows.forms.FormsFlow;
import tests.BaseTest;
import utils.Swipe;

public class FormsTest extends BaseTest {
    @Test
    public void testForms() {
        Swipe swipe = new Swipe(getDriver());
        FormsFlow formsFlow = new FormsFlow(getDriver());
        formsFlow.goToFormsScreen();
        formsFlow.verifyInputField("SDETPRO Appium thanks you");
        formsFlow.verifySwitchToggle();
        swipe.swipeUp();
        formsFlow.selectDropdown();
        formsFlow.verifyActiveBtn();
        formsFlow.verifyInactiveBtn();
    }
}

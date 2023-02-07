package tests.swipe;

import org.testng.annotations.Test;
import test_flows.swipe.SwipeFlow;
import tests.BaseTest;
import utils.Swipe;

public class SwipeFormTest extends BaseTest {
    @Test
    public void testSwipeForm() {
        Swipe swipe = new Swipe(getDriver());
        SwipeFlow swipeFlow = new SwipeFlow(getDriver());
        swipeFlow.goToSwipeScreen();
        swipeFlow.verifyFullOpenSourceCarousel();
        swipe.swipeRightToLeft(80, 1);
        swipeFlow.verifyGreatCommunityCarousel();
        swipe.swipeRightToLeft(80, 1);
        swipeFlow.verifyJsFoundationCarousel();
        swipe.swipeRightToLeft(80, 1);
        swipeFlow.verifySupportVideoCarousel();
        swipe.swipeRightToLeft(80, 1);
        swipeFlow.verifyExtendableCarousel();
        swipe.swipeRightToLeft(80, 1);
        swipeFlow.verifyCompatibleCarouse();
        swipe.swipeUp(30, 4);
        swipeFlow.verifyLogoAtTheEnd();
    }
}

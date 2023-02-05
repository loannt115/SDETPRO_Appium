package tests_learning.testng;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestNGHooks01 extends BaseTestNG{
    //TestNG Hook
    @BeforeClass
    public void beforeClass(){
        System.out.println(this.getClass().getSimpleName() + "|Before Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println(this.getClass().getSimpleName() + "|Before Method");
    }

    @Test(priority = 2)
    public void testSth01(){
        System.out.println(this.getClass().getSimpleName() + " Test method 01");
    }

    @Test(priority = 1, dependsOnMethods = "testSth01")
    public void testSth02(){
        System.out.println(this.getClass().getSimpleName() + " Test method 02");
    }

    @Test
    public void testSth03(){
        System.out.println(this.getClass().getSimpleName() + " Test method 03");
        String actual = "a";
        String expect = "b";
        Assert.assertEquals(actual, expect, "ERR");
    }

    @Test
    public void testSth04() {
        System.out.println(this.getClass().getSimpleName() + " Test method 04");
        String actual = "a";
        String expect = "b";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual, expect, "ERR 1");
        softAssert.assertEquals("actual", "expect", "ERR 2");
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println(this.getClass().getSimpleName() + "|After Method");
    }
}

package day06;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _06_SoftAssertVsHardAssert {

    @Test
    void hardAssertTest() {

        String str = "Hello";

        System.out.println("Before assertion");
        Assert.assertEquals("Hello world", str, "Your test is failed");
        System.out.println("After assertion");
    }

    @Test
    void softAssertTest(){
        String strHomePage="www.facebook.com/homepage";
        String strCartPage="www.facebook.com/cartpage";
        String strEditAccount="www.facebook.com/editaccountpage";

        SoftAssert softAssert = new SoftAssert();

        System.out.println("Before soft assert 1");
        softAssert.assertEquals("www.facebook.com/homepage",strHomePage);
        System.out.println("After soft assert 1");

        System.out.println("Before soft assert 2");
        softAssert.assertEquals("www.facebook.com/profile",strCartPage);
        System.out.println("After soft assert 2");

        System.out.println("Before soft assert 3");
        softAssert.assertEquals("www.facebook.com/setting",strEditAccount);
        System.out.println("After soft assert 3");

        softAssert.assertAll();
    }

}

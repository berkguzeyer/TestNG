package day01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _05_Assertions {

    @Test
    void test1(){
        String actualStr = "John";
        String expectedStr = "John";

        // checks if actual and expected are equal
        Assert.assertEquals(actualStr, expectedStr, "Test has failed.");
    }

    @Test
    void test2(){
        String str1 = "John";
        String str2 = "Snow";
        Assert.assertEquals(str1, str2, "Test has failed.");
    }

    @Test
    void test3(){
        String str1 = "John";
        String str2 = "John";
        Assert.assertNotEquals(str1,str2);
    }

    @Test
    void test4(){
        int num1 = 54;
        int num2 = 37;
        String str1 = "asd";
        String str2 = "asdf";
        Assert.assertTrue(str1.equals(str2), "Test4 has failed!");
    }
    @Test
    void test5(){
        int num1 = 54;
        int num2 = 54;
        Assert.assertTrue(num1==num2, "Test5 has failed!");
    }

    @Test
    void test6(){
        String name = "John";
        Assert.assertNull(name, "Test 6 is not successful");
    }

    @Test
    void test7(){

        String name = "john";
        if (name.equals("john")){
            Assert.fail("Test fails anyways.");
        }


    }


}

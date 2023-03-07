package day06;

import org.testng.annotations.Test;

public class _03_DataProvideFromDifferentClass {


    @Test(dataProvider = "myData", dataProviderClass = _01_DataProvider.class)
    void test1(String username, String password){
        System.out.println("Test 1 is running for -> " + username +" & " + password);
    }


}

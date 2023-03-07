package day06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _01_DataProvider {

    @Test(dataProvider = "myData")
    void test1(String username, String password){
        System.out.println("Test 1 is running for -> " + username +" & " + password);
    }

    @DataProvider
    public Object[][] myData(){
        Object[][] dataList = {{"john","john123"},{"briandoe@email.com","Test123"},{"dragon","dragon7890"}};
        return dataList;
    }

    @Test(dataProvider = "usernames")
    void test2(String username){
        System.out.println("Test 2 is running for -> " + username);
    }

    @DataProvider(name = "usernames")
    public Object[][] dataList2(){
        Object[][] dataList = {{"john"},{"briandoe@email.com"},{"dragon"}};
        return dataList;
    }
}

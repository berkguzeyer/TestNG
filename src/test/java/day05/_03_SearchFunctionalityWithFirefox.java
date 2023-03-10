package day05;

import Utilities.ParameterDriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _03_SearchFunctionalityWithFirefox extends ParameterDriverClass {

    @Test
    @Parameters(value = "searchKeyword")
    void searchFunctionTest(String str) {

        //<input type="text" name="search" value="" placeholder="Search" class="form-control input-lg">
        WebElement searchBox = driver.findElement(By.cssSelector("input[name='search']"));
        searchBox.sendKeys(str);

        //<button type="button" class="btn btn-default btn-lg"><i class="fa fa-search"></i></button>

        WebElement searchButton = driver.findElement(By.cssSelector("button[class=\"btn btn-default btn-lg\"]"));
        searchButton.click();


        List<WebElement> resultList = driver.findElements(By.cssSelector("h4>a"));

        for (WebElement element : resultList) {
            Assert.assertTrue(element.getText().toLowerCase().contains(str));
        }
    }

}

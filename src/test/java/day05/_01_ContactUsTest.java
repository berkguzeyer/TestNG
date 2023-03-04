package day05;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _01_ContactUsTest extends DriverClass {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * login
     * click on Contact Us
     * send a message from xml file
     * check if the url has "success" key word
     * */

    @Test
    @Parameters(value = {"message1", "message2"})
    void contactUs1(String message, String message2){

        WebElement contactUsButton = driver.findElement(By.xpath("//a[text()='Contact Us']"));
        contactUsButton.click();

        WebElement enquiry = driver.findElement(By.id("input-enquiry"));
        enquiry.sendKeys(message);
        enquiry.sendKeys(message2);

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));

    }

    @Test
    @Parameters(value = "message1")
    void contactUs2(String message1){

        WebElement contactUsButton = driver.findElement(By.xpath("//a[text()='Contact Us']"));
        contactUsButton.click();

        WebElement enquiry = driver.findElement(By.id("input-enquiry"));
        enquiry.sendKeys(message1);

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));


    }


}

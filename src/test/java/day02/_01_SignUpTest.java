package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class _01_SignUpTest {

    /** Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Click on My Accout
     * Click on Register
     * Fill int he form with valid informations
     * Accept the agreement
     * Click on Continue button
     * Verify that you are signed up
     */

    @Test
    void signUpTest(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));


        WebElement myAccount = driver.findElement(By.xpath("//a[@title='My Account']"));
        myAccount.click();

        WebElement registerButton = driver.findElement(By.xpath("//a[text()='Register']"));
        registerButton.click();

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Brian");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Doe");

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("briandoe@email.com");

        WebElement telephone = driver.findElement(By.id("input-telephone"));
        telephone.sendKeys("123456789");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("Test123");

        WebElement passwordConfirm = driver.findElement(By.id("input-confirm"));
        passwordConfirm.sendKeys("Test123");

        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        checkbox.click();


        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();


        String actualUrl = driver.getCurrentUrl();
        String expectedUrl ="http://opencart.abstracta.us/index.php?route=account/success";

        Assert.assertEquals(actualUrl, expectedUrl);
        System.out.println("Your test has passed!");


    }

}

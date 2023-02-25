package day01;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_Example {

   @Test
   void loginTest(){
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://opencart.abstracta.us/index.php?route=account/login");

       //testngusbatch@gmail.com
       //usbatch1234


       WebElement userName = driver.findElement(By.id("input-email"));
       userName.sendKeys("testngusbatch@gmail.com");

       WebElement password = driver.findElement(By.id("input-password"));
       password.sendKeys("usbatch1234");

       WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
       loginButton.click();


       WebElement myAccountText = driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]"));


       Assert.assertEquals(myAccountText.getText(),"My Account");

   }
}

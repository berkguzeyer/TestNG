package day06;

import Utilities.DriverClass;
import Utilities.ParameterDriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_PlaceOrderFunctionality extends ParameterDriverClass {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * Search for ipod
     * Add the first result to cart
     * Click on cart icon
     * Click on Check Out
     * Fill the form
     * Click on Confirm and verify that your order is successful
     * */
    @Test
    @Parameters(value = "searchKeyword")
    void searchTest(String searchKeyword){
        WebElement searchBox = driver.findElement(By.cssSelector("input[name='search']"));
        searchBox.sendKeys(searchKeyword);

        WebElement searchButton = driver.findElement(By.cssSelector("button[class=\"btn btn-default btn-lg\"]"));
        searchButton.click();

        //<button type="button" onclick="cart.add('48', '1');"><i class="fa fa-shopping-cart"></i> <span class="hidden-xs hidden-sm hidden-md">Add to Cart</span></button>
        WebElement addToCartButton = driver.findElement(By.cssSelector("button[onclick=\"cart.add('48', '1');\"]"));
        addToCartButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-success.alert-dismissible")));

        //<button type="button" data-toggle="dropdown" data-loading-text="Loading..." class="btn btn-inverse btn-block btn-lg dropdown-toggle" aria-expanded="false"><span id="cart-total"><i class="fa fa-shopping-cart"></i> 1 item(s) - $100.00</span></button>
        WebElement cartButton = driver.findElement(By.xpath("//button[@type='button' and @data-toggle='dropdown' and @class='btn btn-inverse btn-block btn-lg dropdown-toggle']"));
        cartButton.click();

        //<a href="https://opencart.abstracta.us:443/index.php?route=checkout/checkout"><strong><i class="fa fa-share"></i> Checkout</strong></a>
        WebElement checkOutButton = driver.findElement(By.linkText("Checkout"));
        checkOutButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-payment-address")));
        //<input type="button" value="Continue" id="button-payment-address" data-loading-text="Loading..." class="btn btn-primary">
        WebElement billingContinue = driver.findElement(By.id("button-payment-address"));
        billingContinue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-shipping-address")));
        //<input type="button" value="Continue" id="button-shipping-address" data-loading-text="Loading..." class="btn btn-primary">
        WebElement addressContinue = driver.findElement(By.id("button-shipping-address"));
        addressContinue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-shipping-method")));
        //<input type="button" value="Continue" id="button-shipping-method" data-loading-text="Loading..." class="btn btn-primary">
        WebElement deliveryMethodContinue = driver.findElement(By.id("button-shipping-method"));
        deliveryMethodContinue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='checkbox'")));
        //<input type="checkbox" name="agree" value="1">
        WebElement paymentRadioButton = driver.findElement(By.cssSelector("input[type='checkbox'"));
        paymentRadioButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-payment-method")));
        //<input type="button" value="Continue" id="button-payment-method" data-loading-text="Loading..." class="btn btn-primary">
        WebElement paymentContinue = driver.findElement(By.id("button-payment-method"));
        paymentContinue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-confirm")));
        //<input type="button" value="Confirm Order" id="button-confirm" data-loading-text="Loading..." class="btn btn-primary">
        WebElement confirmOrderButton = driver.findElement(By.id("button-confirm"));
        confirmOrderButton.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/h1[text()='Your order has been placed!']")));
        WebElement successMessage = driver.findElement(By.xpath("//div[@id='content']/h1[text()='Your order has been placed!']"));



        Assert.assertTrue(successMessage.getText().contains("placed"));
        System.out.println("Your test has passed!");

    }

}

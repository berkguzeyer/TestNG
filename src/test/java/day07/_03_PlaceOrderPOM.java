package day07;

import Utilities.DriverClass;
import day07._02_PlaceOrderFunctionalityElements;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_PlaceOrderPOM extends DriverClass {

    @Test
    void checkOutTest(){

        _02_PlaceOrderFunctionalityElements elements = new _02_PlaceOrderFunctionalityElements();

        elements.searchBox.sendKeys("ipod");
        elements.searchButton.click();
        elements.addToCartButton.click();
        elements.cartButton.click();
        elements.checkOutButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.continueAddress));
        elements.continueAddress.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.continueShippingAddress));
        elements.continueShippingAddress.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.continueShippingMethod));
        elements.continueShippingMethod.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.paymentRadioButton));
        elements.paymentRadioButton.click();
        elements.paymentContinue.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.confirmOrderButton));
        elements.confirmOrderButton.click();

        wait.until(ExpectedConditions.visibilityOf(elements.successMessage));
        Assert.assertTrue(elements.successMessage.getText().equals("Your order has been placed!"));
    }

}

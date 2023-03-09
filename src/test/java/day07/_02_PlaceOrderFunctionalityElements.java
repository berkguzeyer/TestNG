package day07;

import Utilities.DriverClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _02_PlaceOrderFunctionalityElements {

    public _02_PlaceOrderFunctionalityElements(){
        PageFactory.initElements(DriverClass.driver,this);
    }

    //POM : Page Object Model is a design pattern/structure.

    @FindBy(css = "input[name='search']")
    public WebElement searchBox;


    @FindBy(css = "button[class=\"btn btn-default btn-lg\"]")
    public WebElement searchButton;

    @FindBy(xpath = "//span[text()='Add to Cart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[text()='Shopping Cart']")
    public WebElement cartButton;

    @FindBy(linkText = "Checkout")
    public WebElement checkOutButton;

    @FindBy(id = "button-payment-address")
    public WebElement continueAddress;

    @FindBy(id = "button-shipping-address")
    public WebElement continueShippingAddress;

    @FindBy(id = "button-shipping-method")
    public WebElement continueShippingMethod;

    @FindBy(css = "input[type='checkbox']")
    public WebElement paymentRadioButton;

    @FindBy(id = "button-payment-method")
    public WebElement paymentContinue;

    @FindBy(id = "button-confirm")
    public WebElement confirmOrderButton;

    @FindBy(xpath = "//div[@id='content']/h1[text()='Your order has been placed!']")
    public WebElement successMessage;




}

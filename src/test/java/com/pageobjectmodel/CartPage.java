package com.pageobjectmodel;

import Com.base.Base_Class;
import com.pageobjectmanager.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends Base_Class {

    @FindBy(id = "cartur")
    private WebElement cart;

    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrder;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "card")
    private WebElement card;

    @FindBy(id = "month")
    private WebElement month;

    @FindBy(id = "year")
    private WebElement year;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement purchaseBtn;

    @FindBy(xpath = "//button[text()='OK']")
    private WebElement okBtn;

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    private WebElement thankYouMsg;

    @FindBy(xpath = "//p[@class='lead text-muted ']")
    private WebElement orderDetails;

    @FindBy(id = "logout2")
    private WebElement logout;

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    public void checkoutProduct() throws Exception {

        // Go to Cart
        clickOnElement(cart);

        Thread.sleep(3000);

        // Screenshot of Cart Page
        takeScreenshot("CartPage");

        // Click Place Order
        clickOnElement(placeOrder);

        Thread.sleep(2000);
    }

    public void purchaseProduct() throws Exception {

        passInput(name, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("name"));

        passInput(country, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("country"));

        passInput(city, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("city"));

        passInput(card, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("card"));

        passInput(month, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("month"));

        passInput(year, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("year"));

        clickOnElement(purchaseBtn);
        Thread.sleep(3000);
        System.out.println("Message : " + thankYouMsg.getText());
        System.out.println("Order Details : ");
        System.out.println(orderDetails.getText());

        takeScreenshot("PurchaseSuccess");

        clickOnElement(okBtn);

        Thread.sleep(2000);

        clickOnElement(logout);
    }
}

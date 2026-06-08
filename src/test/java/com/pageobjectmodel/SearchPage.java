package com.pageobjectmodel;
import Com.base.Base_Class;
import Com.interfaceelements.SearchPageInterfaceElements;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class SearchPage extends Base_Class
        implements SearchPageInterfaceElements {

    @FindBy(linkText = "Laptops")
    private WebElement laptopsCategory;

    @FindBy(linkText = "Sony vaio i5")
    private WebElement sonyVaioi5;

    @FindBy(linkText = "Add to cart")
    private WebElement addToCart;

    public SearchPage() {
        PageFactory.initElements(driver, this);
    }

    public void addLaptopToCart() throws InterruptedException {

        clickOnElement(laptopsCategory);

        Thread.sleep(2000);

        clickOnElement(sonyVaioi5);

        Thread.sleep(2000);

        clickOnElement(addToCart);

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();

        System.out.println("Alert Message : " + alert.getText());

        alert.accept();
    }
}

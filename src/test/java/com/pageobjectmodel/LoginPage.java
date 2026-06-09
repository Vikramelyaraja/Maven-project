package com.pageobjectmodel;

import Com.base.Base_Class;
import Com.interfaceelements.LoginPageInterfaceElements;
import com.pageobjectmanager.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends Base_Class implements LoginPageInterfaceElements {

    @FindBy(linkText = linkText_login)
    private static WebElement loginLink;

    @FindBy(id = username_id)
    private static WebElement username;

    @FindBy(css = password_css)
    private static WebElement password;

    @FindBy(xpath = signin_xpath)
    private static WebElement signin;

    @FindBy(id = title_id)
    private static WebElement title;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    protected static String getTextValue(WebElement element) {
        String text = "";
        try {
            text = element.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    public static void validLogin() throws InterruptedException {

        clickOnElement(loginLink);

        Thread.sleep(2000);

        passInput(username, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("username"));

        passInput(password, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("password"));

        clickOnElement(signin);

        Thread.sleep(4000);

        System.out.println("Get Title"+title);


        getTextValue(title);
    }


}

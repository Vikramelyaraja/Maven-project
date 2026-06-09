package com.runner;


import Com.base.Base_Class;
import com.pageobjectmanager.PageObjectManager;

public class TestClass extends Base_Class {

    public static void main(String[] args) throws Exception {

        launchBrowser(PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("browser"));

        launchUrl(PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("url"));

        PageObjectManager.getPageObjectManager().getLoginPage().validLogin();

        PageObjectManager.getPageObjectManager().getSearchPage().addLaptopToCart();
        PageObjectManager.getPageObjectManager().getCartPage().checkoutProduct();
        PageObjectManager.getPageObjectManager().getCartPage().purchaseProduct();


    }
}

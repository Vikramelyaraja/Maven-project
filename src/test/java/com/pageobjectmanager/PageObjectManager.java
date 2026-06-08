package com.pageobjectmanager;

import Com.utility.FileReaderManager;
import com.pageobjectmodel.CartPage;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.SearchPage;

public class PageObjectManager {

    private LoginPage loginPage;
    private FileReaderManager fileReaderManager;
    private static PageObjectManager pageObjectManager;
    private SearchPage searchPage;
    private CartPage cartPage;

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public FileReaderManager getFileReaderManager() {
        if (fileReaderManager == null) {
            fileReaderManager = new FileReaderManager();
        }
        return fileReaderManager;
    }

    public static PageObjectManager getPageObjectManager() {
        if (pageObjectManager == null) {
            pageObjectManager = new PageObjectManager();
        }
        return pageObjectManager;
    }

    public SearchPage getSearchPage() {
        if (searchPage == null) {
            searchPage = new SearchPage();
        }
        return searchPage;
    }



    public CartPage getCartPage() {

        if(cartPage == null) {
            cartPage = new CartPage();
        }

        return cartPage;
    }

}

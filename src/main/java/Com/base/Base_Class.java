package Com.base;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Base_Class {

    public static WebDriver driver;

    protected  static WebDriver launchBrowser(String browserName){
        try{

            if(browserName.equalsIgnoreCase("chrome")){
                driver=new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver=new FirefoxDriver();
            }  else if (browserName.equalsIgnoreCase("edge")) {
                driver=new EdgeDriver();
            }

        } catch (Exception e){
            Assert.fail("ERROR: OCCURE DURING BROWSER LAUNCH");

        }
        driver.manage().window().maximize();
        return driver;
    }

    protected static  void launchUrl(String url){
        try {
            driver.get(url);
        } catch (Exception e){
            Assert.fail("ERROR: OCCURE DURING URL LAUNCH");
        }
    }


    protected  static void passInput(WebElement element,String value){
        try{
            element.sendKeys(value);
        } catch(Exception e){
            Assert.fail("ERROR: OCCURE DURING VALUE PASSING");
        }
    }

    protected  static void clickOnElement(WebElement element){
        try{
            element.click();
        } catch(Exception e){
            Assert.fail("ERROR: OCCURE DURING ELEMENT CLICKING");
        }
    }

    protected static void browserActions(String action, String value){

        if(action.equalsIgnoreCase("get")){

            driver.get(value);

        } else if(action.equalsIgnoreCase("navigateTo")) {

            driver.navigate().to(value);
        }
         else if(action.equalsIgnoreCase("back")){

            driver.navigate().back();

        } else if(action.equalsIgnoreCase("forward")){

            driver.navigate().forward();

        } else if(action.equalsIgnoreCase("refresh")){

            driver.navigate().refresh();
        }

        System.out.println("Current URL : "
                + driver.getCurrentUrl());

        System.out.println("Title : "
                + driver.getTitle());
    }

    protected static void alertHandling(WebElement element, String action, String value) {

        element.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.alertIsPresent());

        if(action.equalsIgnoreCase("accept")) {

            System.out.println(driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();

        } else if(action.equalsIgnoreCase("dismiss")) {

            System.out.println(driver.switchTo().alert().getText());
            driver.switchTo().alert().dismiss();

        } else if(action.equalsIgnoreCase("gettext")) {

            System.out.println(driver.switchTo().alert().getText());

        } else if(action.equalsIgnoreCase("sendkeys")) {

            driver.switchTo().alert().sendKeys(value);

        } else if(action.equalsIgnoreCase("acceptwithtext")) {

            driver.switchTo().alert().sendKeys(value);
            driver.switchTo().alert().accept();
        }
    }

    protected static Object getData(String action, WebElement element, String attributeName) {

        if(action.equalsIgnoreCase("title")) {

            return driver.getTitle();

        } else if(action.equalsIgnoreCase("url")) {

            return driver.getCurrentUrl();

        } else if(action.equalsIgnoreCase("text")) {

            return element.getText();

        } else if(action.equalsIgnoreCase("attribute")) {

            return element.getAttribute(attributeName);

        } else if(action.equalsIgnoreCase("options")) {

            Select select = new Select(element);

            List<WebElement> options = select.getOptions();

            for(WebElement option : options) {

                System.out.println(option.getText());
            }

            return options;
        }

        return null;
    }



//    protected static void takeScreenshot(String fileName) {
//
//        try {
//
//            TakesScreenshot ts = (TakesScreenshot) driver;
//
//            File source = ts.getScreenshotAs(OutputType.FILE);
//
//            File destination = new File("C:\\Users\\kumar\\IdeaProjects\\Maven_Project\\Images\\" + fileName + ".png");
//
//            FileHandler.copy(source, destination);
//
//            System.out.println("Screenshot Saved Successfully");
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }
//    }

    protected static void takeScreenshot(String fileName) {

        try {

            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE);

            File destination = new File("Screenshots\\" + fileName + ".png");

            FileHandler.copy(source, destination);

        } catch (Exception e) {

            Assert.fail("ERROR DURING SCREENSHOT");
        }
    }

    protected  static void windowHandling(int num){
        try{
            List<String> allWindow=new ArrayList<>(driver.getWindowHandles());

            System.out.println("Windows Count: " + allWindow.size());
            System.out.println("Requested Index: " + num);

            driver.switchTo().window(allWindow.get(num));
        } catch(Exception e){
            Assert.fail("ERROR: OCCURE DURING WINDOW HANDLING");
        }
    }


    protected  static void selectOptions(WebElement element,String type,String value){
        try{
            Select select =new Select(element);
            if(type.equalsIgnoreCase("text")){
                select.selectByVisibleText(value);
            } else if (type.equalsIgnoreCase("index")){
                select.selectByIndex(Integer.parseInt(value));
            } else if(type.equalsIgnoreCase("value")){
                select.selectByValue(value);
            }
        } catch(Exception e){
            Assert.fail("ERROR: OCCURE DURING SELECT OPTIONS");
        }
    }

    protected  static void deSelectOptions(WebElement element,String type,String value){
        try{
            Select select =new Select(element);
            if(type.equalsIgnoreCase("text")){
                select.deselectByVisibleText(value);
            } else if (type.equalsIgnoreCase("index")){
                select.deselectByIndex(Integer.parseInt(value));
            } else if(type.equalsIgnoreCase("value")){
                select.deselectByValue(value);
            }
        } catch(Exception e){
            Assert.fail("ERROR: OCCURE DURING DESELECT OPTIONS");
        }
    }

    protected  static void closeBrowser(){
        try{
            driver.close();
        } catch(Exception e){
            Assert.fail("ERROR: OCCURE DURING BROWSER CLOSING");
        }
    }
    protected  static void browserTermination(){
        try{
            driver.quit();
        } catch(Exception e){
            Assert.fail("ERROR: OCCURE DURING BROWSER TERMINATION");
        }
    }

}

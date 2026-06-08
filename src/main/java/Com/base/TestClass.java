package Com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TestClass  extends Base_Class{
    public static void main(String[] args) throws InterruptedException {
        launchBrowser("chrome");
        launchUrl("https://www.google.com/");
        WebElement element =driver.findElement(By.name("q"));
        passInput(element,"Rose");
        clickOnElement(element);
        browserActions("get", "https://www.google.com");
        browserActions("navigateTo", "https://www.amazon.in");
        browserActions("back", null);
        browserActions("forward", null);
        browserActions("refresh", null);
        browserActions("navigateTo", "https://letcode.in/alert");

        Thread.sleep(2000);


        WebElement simple = driver.findElement(By.id("accept"));

        alertHandling(simple, "accept", null);

        WebElement confirm = driver.findElement(By.id("confirm"));

        alertHandling(confirm, "dismiss", null);

        WebElement prompt = driver.findElement(By.id("prompt"));

        alertHandling(prompt, "acceptwithtext", "Vikram");

        System.out.println(getData("title", null, null));
        System.out.println(getData("url", null, null));


        takeScreenshot("GoogleHomePage");

        windowHandling(1);
        selectOptions(element,"index","1");
        deSelectOptions(element,"index","1");
        browserTermination();

    }
}

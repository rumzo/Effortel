package core;
import org.openqa.selenium.By;
import utils.Browser;
import org.openqa.selenium.By;

public class BasePage {

    protected static void type(By locator, String type) {
        Browser.driver.findElement(locator).sendKeys(type);
    }

    protected static void click(By locator) {
        Browser.driver.findElement(locator).click();
    }

    protected static String getText(By locator) {
        return Browser.driver.findElement(locator).getText();
    }

}

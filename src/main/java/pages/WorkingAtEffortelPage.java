package pages;
import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Browser;

public class WorkingAtEffortelPage extends BasePage {

    private static final By CONTACT_US_BUTTON = By.xpath("//div[@class='link']//span[@class='in']");
    private static final String expectedPageTitle = "Working at Effortel - Effortel";

    public static void verifyPageTitle() {
       String actualTitle = Browser.driver.getTitle();
       Assert.assertEquals(actualTitle, expectedPageTitle);
    }

    public static void navigateToContactUsPage() {
        click(CONTACT_US_BUTTON);
    }
}

package pages;
import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.Browser;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage extends BasePage {

    private static final By WORKING_AT_EFFORTEL_BUTTON = By.xpath("//div[@class='buttonWrapper']"); // ("//a[@class='btnFill']/span");
    private static final By ACCEPT_COOKIES_BUTTON = By.id("wt-cli-accept-all-btn");
    private static final By ABOUT_US_BUTTON = By.xpath("//div[@class='menuLink']/a[contains(@href,'about')]");
    private static final By EFFORTEL_ELASTIC_BUTTON = By.xpath("//div[@class='dropdownMenu']//a[contains(@href,'elastic')]");
    private static final By OUR_SERVICES_BUTTON = By.xpath("//div[@class='menuLink']/a[contains(@href,'our-services')]");
    private static final By ELASTIC_PAGE_TITLE = By.xpath("//div[contains(@class,'titleBlock')]/h1");
    private static final By ELASTIC_PAGE_CONTENT = By.xpath("//div[@class='contentBlock']/div[contains(@class,'textBlock')]/p");

    private static final String elasticPageTitle = "EFFORTEL ELASTIC";
    private static final String elasticPageContent = "For MNO and IT companies. Embed our technical expertise in your IT team with dynamic and skilled on-demand IT resources";

    private static Actions action = new Actions(Browser.driver);


    public static void navigateToHomePage() {
        Browser.driver.get("https://www.effortel.com/");
    }

    public static void navigateToWorkingAtEffortel()  {
        click(ACCEPT_COOKIES_BUTTON);
        click(WORKING_AT_EFFORTEL_BUTTON);
        Browser.driver.getWindowHandles().forEach(tab -> Browser.driver.switchTo().window(tab));
    }

    public static void verifyAboutUsButton() {
        WebElement aboutUs = Browser.driver.findElement(ABOUT_US_BUTTON);
        aboutUs.isDisplayed();
    }

    public static void verifyElasticPage(String messageForWrongTitle, String messageForWrongContent) {
        WebElement ourServices = Browser.driver.findElement(OUR_SERVICES_BUTTON);
        action.moveToElement(ourServices).perform();
        click(EFFORTEL_ELASTIC_BUTTON);

        String actualPageTitle = getText(ELASTIC_PAGE_TITLE).replaceAll("\\s+", " ");
        String actualPageContent = getText(ELASTIC_PAGE_CONTENT).replaceAll("\\s+", " ");

        Assert.assertEquals(actualPageTitle, elasticPageTitle, messageForWrongTitle );
        Assert.assertEquals(actualPageContent, elasticPageContent, messageForWrongContent);
    }

    public static void verifyHomePageLinks() {
        List<String> expectedPageTitles = Arrays.asList("About Us - Effortel", "Our Products - Effortel", "Our Services - Effortel","Knowledge center - Effortel", "Contact - Effortel");
        List<String> actualPageTitles = new ArrayList<>();

            int numberLinks = Browser.driver.findElements(By.xpath("//ul[@class='menuList']//div[contains(@class,'menuLink')]")).size();

            for (int i = 0; i < numberLinks; i++) {
                WebElement link = Browser.driver.findElements(By.xpath("//ul[@class='menuList']//div[contains(@class,'menuLink')]")).get(i);
                link.click();

                actualPageTitles.add(Browser.driver.getTitle());
            }

        Assert.assertEquals(expectedPageTitles, actualPageTitles);

        }
}
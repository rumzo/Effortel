package tests;
import core.BaseTest;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import pages.WorkingAtEffortelPage;

public class HomePageTests extends BaseTest {

    @Test
    public static void submitSuccessfulEnquiry()  {
        HomePage.navigateToHomePage();
        HomePage.navigateToWorkingAtEffortel();
        WorkingAtEffortelPage.verifyPageTitle();
        WorkingAtEffortelPage.navigateToContactUsPage();
        ContactUsPage.fillForm("firstName", "lastName", "test123@test.cc", "55555", "test123");
        ContactUsPage.verifyThankYouMessage("Title of Thank you message is not as expected!", "Content block of Thank you message is not as expected!");
    }

    @Test
    public static void checkElasticPage() {
        HomePage.navigateToHomePage();
        HomePage.verifyElasticPage("The title is not as expected, please check!", "The content block is not as expected, please check!");
    }

    @Test
    public static void checkHeaderPages() {
        HomePage.navigateToHomePage();
        HomePage.verifyAboutUsButton();
        HomePage.navigateToHomePage();
        HomePage.verifyHomePageLinks();
    }
}

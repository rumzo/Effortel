package pages;
import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.Browser;

public class ContactUsPage extends BasePage {

    private static final By FIRST_NAME_FIELD = By.id("contact-form-0-first_name");
    private static final By LAST_NAME_FIELD = By.id("contact-form-0-last_name");
    private static final By EMAIL_FIELD = By.id("contact-form-0-email");
    private static final By PHONE_NUMBER_FIELD = By.id("contact-form-0-phone");
    private static final By MESSAGE_FIELD = By.id("contact-form-0-message");
    private static final By TC_CHECKBOX = By.xpath("//div[@class='input-group']//div[@class='checkButton']");
    private static final By SUBMIT_ENQUIRY_BUTTON = By.xpath("//div[@class='buttonBlock']/button[@type='submit']");

    private static final By SUCCESSFUL_MESSAGE_TITLE = By.xpath("//div[@class='formFeedbackMessage']//span");
    private static final By SUCCESSFUL_MESSAGE_CONTENT = By.xpath("//div[@class='formFeedbackMessage']/div[@class='content']/p[1]");

    private static final String expectedThankYouMessageTitle = "Thank you!";
    private static final String expectedThankYouMessageContent = "Your submission has been received!";

    public static void fillForm(String firstName, String lastName, String email, String phoneNumber, String message) {
        type(FIRST_NAME_FIELD, firstName);
        type(LAST_NAME_FIELD, lastName);
        type(EMAIL_FIELD, email);
        type(PHONE_NUMBER_FIELD, phoneNumber);
        type(MESSAGE_FIELD, message);
        click(TC_CHECKBOX);
        click(SUBMIT_ENQUIRY_BUTTON);
    }

    public static void verifyThankYouMessage(String messageOnFailureTitle, String messageOnFailureContent) {
        WebElement pageTitle = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESSFUL_MESSAGE_TITLE));
        String actualTitle = getText(SUCCESSFUL_MESSAGE_TITLE);
        String actualContent = getText(SUCCESSFUL_MESSAGE_CONTENT);

        Assert.assertEquals(actualTitle, expectedThankYouMessageTitle, messageOnFailureTitle);
        Assert.assertEquals(actualContent, expectedThankYouMessageContent, messageOnFailureContent);
    }


}

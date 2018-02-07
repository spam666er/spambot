package Google;

import Utilities.WebElementManipulator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMailboxPage extends WebElementManipulator {

    @FindBy(xpath = "//div[contains(text(),'COMPOSE')]")
    private WebElement composeButton;

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement recepientTextArea;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement subjectTextArea;

    @FindBy(xpath = "//div[@aria-label='Message Body'][@role='textbox']")
    private WebElement messageTextArea;

    @FindBy(xpath = "//div[contains(text(),'Send')]")
    private WebElement sendButton;

    public GoogleMailboxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleMailboxPage clickOnComposeButton() {
        clickOnWebElement(composeButton);
        return this;
    }

    public GoogleMailboxPage enterRecepient(String recepient) {
        inputString(recepientTextArea, recepient + " ");
        return this;
    }

    public GoogleMailboxPage enterSubject(String subject) {
        inputString(subjectTextArea, subject);
        return this;
    }


    public GoogleMailboxPage enterMessage(String message) {
        inputString(messageTextArea, message);
        return this;
    }


    public GoogleMailboxPage clickSendMessage() {
        clickOnWebElement(sendButton);
        return this;
    }
}

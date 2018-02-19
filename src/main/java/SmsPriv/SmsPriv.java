package SmsPriv;

import Utilities.WebElementManipulator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmsPriv extends WebElementManipulator {

    @FindBy(xpath = "//input[@id='number']")
    private WebElement numberInput;

    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement messageTextArea;

    @FindBy(xpath = "//input[@id='sender']")
    private WebElement senderInput;

    @FindBy(xpath = "//button[@id='send']")
    private WebElement sendButton;

    @FindBy(xpath = "//a[@class='accept']")
    private WebElement acceptCookiePolicyButton;

    public SmsPriv(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SmsPriv enterNumber(String number) {
        inputString(numberInput, number);
        return this;
    }

    public SmsPriv enterMessage(String message) {
        inputString(messageTextArea, message);
        return this;
    }

    public SmsPriv enterSender(String sender) {
        inputString(senderInput, sender);
        return this;
    }

    public SmsPriv acceptCookiePolicy() {
        try {
            clickOnWebElement(acceptCookiePolicyButton);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return this;
    }

    public SmsPriv clickSendButton() {
        clickOnWebElement(sendButton);
        return this;
    }
}

package Google;

import Utilities.WebElementManipulator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleGmailSignInPage extends WebElementManipulator {

    @FindBy(id = "identifierId")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "identifierNext")
    private WebElement afterUsernameNextButton;

    @FindBy(id = "passwordNext")
    private WebElement afterPasswordNextButton;

    public GoogleGmailSignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleGmailSignInPage inputUsername(String username) {
        inputString(emailInput, username);
        return this;
    }

    public GoogleGmailSignInPage inputPassword(String password) {
        inputString(passwordInput, password);
        return this;
    }

    public GoogleGmailSignInPage clickNextButtonAfterUsername() {
        clickOnWebElement(afterUsernameNextButton);
        return this;
    }

    public GoogleMailboxPage clickNextButtonAfterPassword() {
        clickOnWebElement(afterPasswordNextButton);
        return new GoogleMailboxPage(driver);
    }
}

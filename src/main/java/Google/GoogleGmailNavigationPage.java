package Google;

import Utilities.WebElementManipulator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleGmailNavigationPage extends WebElementManipulator {

    @FindBy(css = "a[class*='gmail-nav__nav-link__sign-in']")
    private WebElement signInButton;

    public GoogleGmailNavigationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleGmailSignInPage clickOnSignInButton() {
        clickOnWebElement(signInButton);
        return new GoogleGmailSignInPage(driver);
    }
}

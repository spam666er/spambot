package Google;

import Utilities.WebElementManipulator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage extends WebElementManipulator {

    @FindBy(xpath = "(//a[@class='gb_P'])[1]")
    private WebElement gmailMailboxButton;

    public GoogleMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleGmailNavigationPage clickOnGmailMailboxbutton() {
        clickOnWebElement(gmailMailboxButton);
        return new GoogleGmailNavigationPage(driver);
    }
}

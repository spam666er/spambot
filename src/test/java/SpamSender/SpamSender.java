package SpamSender;

import Google.GoogleMainPage;
import Utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SpamSender {

    private WebDriver driver;
    private GoogleMainPage googleMainPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://google.com/");
        driver.manage().window().maximize();

        googleMainPage = new GoogleMainPage(driver);
    }

    @DataProvider(name = "emailsList")
    public static Object[][] emailsList() {
        return new Object[][] {
                {"edwarddziaslo123@gmail.com"},
                {"spam666catcher@gmail.com"}
        };
    }

    @Test(dataProvider = "emailsList")
    public void SpamSenderTest(String email) {
        googleMainPage
                .clickOnGmailMailboxbutton()
                .clickOnSignInButton()

                .inputUsername("spam666catcher")
                .clickNextButtonAfterUsername()
                .inputPassword("ProszeDajMiSpam")
                .clickNextButtonAfterPassword()

                .clickOnComposeButton()
                .enterRecepient(email)
                .enterSubject(Utils.getRandomData("titles"))
                .enterMessage(Utils.getRandomData("messages"))
                .clickSendMessage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

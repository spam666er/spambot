package SpamSender;

import SmsPriv.SmsPriv;
import Utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Utilities.Utils.getRandomInt;

public class SmsSpam {

    private WebDriver driver;
    private SmsPriv smsPriv;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://sms.priv.pl/");
        driver.manage().window().maximize();

        smsPriv = new SmsPriv(driver);
    }

    @DataProvider(name = "numbers")
    public static Object[][] nums() {
        return new Object[][]{
                {"608862323"}
        };
    }

    @Test(dataProvider = "numbers")
    public void sendSms(String number) {
        smsPriv.acceptCookiePolicy()
                .enterNumber(number)
                .enterMessage(Utils.getRandomData("quotes", getRandomInt(4)))
                .enterSender("M")
                .clickSendButton();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

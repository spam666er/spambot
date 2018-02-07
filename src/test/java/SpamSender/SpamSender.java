package SpamSender;

import Google.GoogleMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SpamSender {

    private WebDriver driver;
    private GoogleMainPage googleMainPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://google.com/");
        driver.manage().window().maximize();

        googleMainPage = new GoogleMainPage(driver);
    }

    @Test
    public void SpamSenderTest() {
        googleMainPage
                .clickOnGmailMailboxbutton()
                .clickOnSignInButton()

                .inputUsername("spam666catcher")
                .clickNextButtonAfterUsername()
                .inputPassword("ProszeDajMiSpam")
                .clickNextButtonAfterPassword()

                .clickOnComposeButton()
                .enterRecepient("sylwia.gryglicka@o2.pl")
                .enterSubject("OTWORZ MNIE !!! :D")
                .enterMessage("KOCHAM CIE WARIATKO XDXD <3333333 :*****")
                .clickSendMessage();
    }

    @AfterTest
    public void tearDown() {
        //driver.quit();
    }
}

package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementManipulator {

    protected WebDriver driver;
    protected final Wait<WebDriver> wait;
    private JavascriptExecutor jse;

    public WebElementManipulator(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 25);
        jse = (JavascriptExecutor) driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected void waitUntilElementIsVisibleAndClickable(WebElement element) {
        waitUntilElementIsVisible(element);
        waitUntilElementIsClickable(element);
    }

    public void waitUntilElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitUntilElementIsClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void clickOnWebElement(WebElement element) {
        waitUntilElementIsVisibleAndClickable(element);
        element.click();
    }

    protected void inputString(WebElement element, String input) {
        waitUntilElementIsVisibleAndClickable(element);
        element.sendKeys(input);
    }
}

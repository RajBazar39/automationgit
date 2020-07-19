package stepdefs.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.qameta.allure.Allure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class BaseScreen {

    protected final AppiumDriver driver;
    public WebDriverWait wait;

    public BaseScreen(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);

        // Initialize page factory for Page Object Model element identification
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    void click(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    String getText(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        return driver.findElement(element).getText();
    }

    boolean isEnableElement(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        Assert.assertTrue(driver.findElement(element).isEnabled());
        return true;
    }

    void assertText(WebElement element, String text) {
        Assert.assertEquals(element.getText(), text);
    }

    void clickElementWithClassAndLabel(String className, String label) {
        WebElement element = driver.findElementByClassName(className);
        assertText(element, label);
        element.click();
    }

    public void embedScreenshot(String screenName) throws FileNotFoundException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Allure.addAttachment(screenName, new FileInputStream(screenshot));
    }
}

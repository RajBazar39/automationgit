package stepdefs.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.cucumber.java.Scenario;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import stepdefs.AppiumController;

import javax.naming.Context;
import java.io.FileNotFoundException;

public class LoginScreen extends BaseScreen {

    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement okButtonAlertElement;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='phone']")
    @AndroidFindBy(id = "com.matrixx.android:id/phone_number")
    private MobileElement loginNUmber;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='CONTINUE WITH PHONE NUMBER']")
    @AndroidFindBy(id = "com.matrixx.android:id/phone_button")
    private MobileElement loginWnumberButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='CONTINUE WITH FACEBOOK']")
    @AndroidFindBy(id = "com.matrixx.android:id/facebook_button")
    private MobileElement loginWFcbookButton;

    @iOSXCUITFindBy(accessibility = "positiveButton")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Invalid Phone Number')]")
    private MobileElement invalidElement;

    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    @Step
    public void enterInvalidLoginUserID() throws FileNotFoundException {
        try {
            String phoneNumber = AppiumController.isPlatformIOS() ? "+".concat("2345678901") : "2345678901";
            if (AppiumController.isPlatformANDROID()) {
                wait.until(ExpectedConditions.elementToBeClickable(loginNUmber));
                loginNUmber.clear();
                loginNUmber.sendKeys(phoneNumber);
                loginWnumberButton.click();
                wait.until(ExpectedConditions.elementToBeClickable(invalidElement));
                Assert.assertEquals(invalidElement.isDisplayed(), true);
                embedScreenshot("Invalid User ID");
            } else {
                wait.until(ExpectedConditions.elementToBeClickable(loginWnumberButton));
                loginWnumberButton.click();
                wait.until(ExpectedConditions.elementToBeClickable(loginNUmber));
                loginNUmber.clear();
                loginNUmber.sendKeys(phoneNumber);
                Assert.assertEquals(invalidElement.isEnabled(),false);
                embedScreenshot("Invalid User ID");
            }
        } catch (Exception e) {
            embedScreenshot("Login Screen");
            Assert.fail(e.getMessage().toString());
        }
    }

    @Step
    public void enterValidLoginUserID() throws FileNotFoundException {
        try {
            String phoneNumber = AppiumController.isPlatformIOS() ? "+".concat(AppiumController.PHONE_NUMBER) : AppiumController.PHONE_NUMBER;
            if (AppiumController.isPlatformANDROID()) {
                wait.until(ExpectedConditions.elementToBeClickable(loginNUmber));
                loginNUmber.clear();
                loginNUmber.sendKeys(phoneNumber);
                loginWnumberButton.click();
            } else {
                wait.until(ExpectedConditions.elementToBeClickable(loginWnumberButton));
                loginWnumberButton.click();
                wait.until(ExpectedConditions.elementToBeClickable(loginNUmber));
                loginNUmber.clear();
                loginNUmber.sendKeys(phoneNumber);
                wait.until(ExpectedConditions.elementToBeClickable(invalidElement));
                invalidElement.click();
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(okButtonAlertElement));
                    okButtonAlertElement.click();
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            embedScreenshot("Login Screen");
            Assert.fail(e.getMessage().toString());
        }
    }

}
package stepdefs.screens;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class OBLandingScreen extends BaseScreen {

    @iOSXCUITFindBy(accessibility = "welcomeText")
    @AndroidFindBy(id = "com.matrixx.android:id/hello_label")
    private MobileElement welcomeLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch")
    @AndroidFindBy(id = "com.matrixx.android:id/terms_checkbox")
    private MobileElement termsCheckBoxElement;

    @iOSXCUITFindBy(accessibility = "agree")
    @AndroidFindBys({
            @AndroidBy(className = "android.widget.Button", priority = 1),
            @AndroidBy(uiAutomator = "new UiSelector().textContains(\"AGREE & CONTINUE\")")
    })
    private MobileElement agreeButtonElement;

    @iOSXCUITFindBy(accessibility = "signup")
    @AndroidFindBy(id = "com.matrixx.android:id/signup_button")
    private MobileElement signUpButtonElement;

    @iOSXCUITFindBy(accessibility = "signin")
    @AndroidFindBy(id = "com.matrixx.android:id/signin_button")
    private MobileElement signInButtonElement;

    //@iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(id = "com.matrixx.android:id/btn_settings")
    private MobileElement settingsButtonElement;

    public OBLandingScreen(AppiumDriver driver) {
        super(driver);
    }

    @Step
    public void acceptTCAndSignup() {
        wait.until(ExpectedConditions.elementToBeClickable(termsCheckBoxElement));
        termsCheckBoxElement.click();
        agreeButtonElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(signInButtonElement));
        signUpButtonElement.click();
    }

    @Step
    public void acceptTCAndSignin() {
        wait.until(ExpectedConditions.elementToBeClickable(termsCheckBoxElement));
        termsCheckBoxElement.click();
        agreeButtonElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(signInButtonElement));
        signInButtonElement.click();
    }

    @Step
    public void clickSignIN() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButtonElement));
        signInButtonElement.click();
    }

    @Step
    public void confirmLandingCurrentlyDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(welcomeLabel));
        Assert.assertEquals(welcomeLabel.isDisplayed(), true);
    }
}

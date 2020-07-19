package stepdefs.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OBWelcomeScreen extends BaseScreen {

    @iOSXCUITFindBy(accessibility = "goToMyPage")
    @AndroidFindBy(id = "com.matrixx.android:id/btn_go")
    private MobileElement continueButtonElement;

    public OBWelcomeScreen(AppiumDriver driver) {
        super(driver);
    }

    @Step
    public void continueToMyPage() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButtonElement));
        continueButtonElement.click();
    }
}
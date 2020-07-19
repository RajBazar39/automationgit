package stepdefs.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OBPlanEditScreen extends BaseScreen {

    @iOSXCUITFindBy(accessibility = "activate")
    @AndroidFindBy(id = "com.matrixx.android:id/activate_button")
    private MobileElement continueActivationButtonElement;

    public OBPlanEditScreen(AppiumDriver driver) {
        super(driver);
    }

    @Step
    public void continueActivation() {
        wait.until(ExpectedConditions.elementToBeClickable(continueActivationButtonElement));
        continueActivationButtonElement.click();
    }
}
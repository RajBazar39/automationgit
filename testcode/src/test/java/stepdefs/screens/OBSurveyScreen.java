package stepdefs.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OBSurveyScreen extends BaseScreen {

    @iOSXCUITFindBy(accessibility = "negative")
    @AndroidFindBy(id = "com.matrixx.android:id/btn_surveyNo")
    private MobileElement noButtonElement;

    @iOSXCUITFindBy(accessibility = "positive")
    @AndroidFindBy(id = "com.matrixx.android:id/btn_surveyYes")
    private MobileElement yesButtonElement;

    public OBSurveyScreen(AppiumDriver driver) {
        super(driver);
    }

    @Step
    public void completeSurvey() {
        wait.until(ExpectedConditions.elementToBeClickable(yesButtonElement));
        yesButtonElement.click();
        yesButtonElement.click();
        noButtonElement.click();
    }
}
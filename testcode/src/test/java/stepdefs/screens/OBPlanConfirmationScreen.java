package stepdefs.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OBPlanConfirmationScreen extends BaseScreen {

    @iOSXCUITFindBy(accessibility = "jumpToActivation")
    @AndroidFindBy(id = "com.matrixx.android:id/activate_button")
    private MobileElement continueActivationButtonElement;

    @iOSXCUITFindBy(accessibility = "tellUsMore")
    @AndroidFindBy(id = "com.matrixx.android:id/tell_us_button")
    private MobileElement tellUsMoreButtonElement;

    @iOSXCUITFindBy(accessibility = "noThanks")
    @AndroidFindBy(id = "android:id/button2")
    private MobileElement noThanksButtonElement;

    @iOSXCUITFindBy(accessibility = "addOffer")
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement addThisOfferButtonElement;

    public OBPlanConfirmationScreen(AppiumDriver driver) {
        super(driver);
    }

    public void continueActivation() {
        wait.until(ExpectedConditions.elementToBeClickable(continueActivationButtonElement));
        continueActivationButtonElement.click();
    }

    public void startSurvey() {
        wait.until(ExpectedConditions.elementToBeClickable(tellUsMoreButtonElement));
        tellUsMoreButtonElement.click();
    }

    public void rejectRecommendedOffers() {
        wait.until(ExpectedConditions.elementToBeClickable(noThanksButtonElement));
        noThanksButtonElement.click();
    }
}


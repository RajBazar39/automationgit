package stepdefs.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import stepdefs.AppiumController;

public class OBPhoneNumberScreen extends BaseScreen {

    @iOSXCUITFindBy(accessibility = "phone")
    @AndroidFindBy(id = "com.matrixx.android:id/et_phone_number")
    private MobileElement phoneFieldElement;

    @iOSXCUITFindBy(accessibility = "send")
    @AndroidFindBy(id = "com.matrixx.android:id/btn_confirm")
    private MobileElement nextButtonElement;

    public OBPhoneNumberScreen(AppiumDriver driver) {
        super(driver);
    }

    @Step
    public void inputPhoneNumberAndContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(phoneFieldElement));
        phoneFieldElement.click();
        String phoneNumber = AppiumController.isPlatformIOS() ? "+".concat(AppiumController.PHONE_NUMBER) : AppiumController.PHONE_NUMBER;
        phoneFieldElement.sendKeys(phoneNumber);
        nextButtonElement.click();
    }
}
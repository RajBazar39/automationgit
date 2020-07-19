package stepdefs.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import stepdefs.AppiumController;

public class OBRegistrationScreen extends BaseScreen {

    private final String iosNameFieldLocator = "name";
    private final String androidNameFieldLocator = "com.matrixx.android:id/et_name";
    @iOSXCUITFindBy(accessibility = iosNameFieldLocator)
    @AndroidFindBy(id = androidNameFieldLocator)
    private MobileElement nameFieldElement;

    @iOSXCUITFindBy(accessibility = "password")
    @AndroidFindBy(id = "com.matrixx.android:id/et_password")
    private MobileElement passwordFieldElement;

    @iOSXCUITFindBy(accessibility = "reenterPass")
    @AndroidFindBy(id = "com.matrixx.android:id/et_password_confirm")
    private MobileElement passwordConfirmFieldElement;

    @iOSXCUITFindBy(accessibility = "continue")
    @AndroidFindBy(id = "com.matrixx.android:id/btn_confirm")
    private MobileElement saveButtonElement;

    public OBRegistrationScreen(AppiumDriver driver) {
        super(driver);
    }

    @Step
    public void registerDummySubscriber() {

        if (AppiumController.isPlatformIOS()) {
            wait.until(ExpectedConditions.presenceOfElementLocated(new MobileBy.ByAccessibilityId(iosNameFieldLocator)));
        } else if (AppiumController.isPlatformANDROID()) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(androidNameFieldLocator)));
        }

        nameFieldElement.sendKeys("Andy");
        passwordFieldElement.sendKeys("Password");
        passwordConfirmFieldElement.sendKeys("Password");

        driver.hideKeyboard();
        if (AppiumController.isPlatformANDROID()) {
            saveButtonElement.click();
        }
    }
}

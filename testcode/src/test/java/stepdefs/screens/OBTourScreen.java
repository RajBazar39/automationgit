package stepdefs.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OBTourScreen extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"GET STARTED\"]")
    @AndroidFindBy(id = "com.matrixx.android:id/button")
    private MobileElement skipButtonElement;

    public OBTourScreen(AppiumDriver driver) {
        super(driver);
    }

    @Step
    public void skipTour() {
        wait.until(ExpectedConditions.elementToBeClickable(skipButtonElement));
        skipButtonElement.click();
    }
}

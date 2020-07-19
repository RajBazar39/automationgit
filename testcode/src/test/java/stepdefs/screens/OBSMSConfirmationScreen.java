package stepdefs.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import stepdefs.AppiumController;

public class OBSMSConfirmationScreen extends BaseScreen {

    @iOSXCUITFindBy(accessibility = "continue")
    @AndroidFindBy(id = "com.matrixx.android:id/btn_confirm")
    private MobileElement nextButtonElement;

    @iOSXCUITFindBy(accessibility = "code")
    @AndroidFindBy(id = "com.matrixx.android:id/pin_edit")
    private MobileElement pinFieldElement;

//    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"0\"])[1]")
//    private MobileElement iOSPinField1Element;

    @iOSXCUITFindBy(accessibility = "0")
    private MobileElement keyboard0KeyElement;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"0\"])[2]")
    private MobileElement iOSPinField2Element;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"0\"])[3]")
    private MobileElement iOSPinField3Element;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"0\"])[4]")
    private MobileElement iOSPinField4Element;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"0\"])[5]")
    private MobileElement iOSPinField5Element;

    public OBSMSConfirmationScreen(AppiumDriver driver) {
        super(driver);
    }

    @Step
    public void useDummySmsCode() {
        if (AppiumController.isPlatformIOS()) {
            wait.until(ExpectedConditions.elementToBeClickable(pinFieldElement));
            pinFieldElement.click();

            wait.until(ExpectedConditions.elementToBeClickable(keyboard0KeyElement));
            keyboard0KeyElement.click();
            keyboard0KeyElement.click();
            keyboard0KeyElement.click();
            keyboard0KeyElement.click();
            keyboard0KeyElement.click();

        } else if (AppiumController.isPlatformANDROID()) {
            wait.until(ExpectedConditions.elementToBeClickable(pinFieldElement));
            pinFieldElement.sendKeys("00000");
        }
        wait.until(ExpectedConditions.elementToBeClickable(nextButtonElement));
        nextButtonElement.click();
    }

}


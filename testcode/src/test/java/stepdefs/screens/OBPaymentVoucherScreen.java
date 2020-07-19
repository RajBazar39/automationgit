package stepdefs.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import stepdefs.AppiumController;

public class OBPaymentVoucherScreen extends BaseScreen {

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"arrowButton\"])[1]")
    private MobileElement voucherAccordionArrowElement;

    @iOSXCUITFindBy(accessibility = "number")
    @AndroidFindBy(id = "com.matrixx.android:id/et_voucher_number")
    private MobileElement voucherFieldElement;

    @iOSXCUITFindBy(accessibility = "done")
    @AndroidFindBy(id = "com.matrixx.android:id/btn_voucher_top_up")
    private MobileElement topupButtonElement;

    public OBPaymentVoucherScreen(AppiumDriver driver) {
        super(driver);
    }

    @Step
    public void topUpUsingDummyVoucher() {
        // iOS specific behaviour
        if (AppiumController.isPlatformIOS()) {
            wait.until(ExpectedConditions.elementToBeClickable(voucherAccordionArrowElement));
            voucherAccordionArrowElement.click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(voucherFieldElement));
        voucherFieldElement.sendKeys("000000");
        topupButtonElement.click();
    }
}

package stepdefs.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OBPaymentOptionsScreen extends BaseScreen {


    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"title\"])[1]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]")
    private MobileElement voucherButtonElement;

    public OBPaymentOptionsScreen(AppiumDriver driver) {
        super(driver);
    }

    @Step
    public void selectVoucher() {
        wait.until(ExpectedConditions.elementToBeClickable(voucherButtonElement));
        voucherButtonElement.click();
    }
}


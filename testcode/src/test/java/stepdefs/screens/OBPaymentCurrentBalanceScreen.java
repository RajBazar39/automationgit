package stepdefs.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OBPaymentCurrentBalanceScreen extends BaseScreen {

    @iOSXCUITFindBy(accessibility = "topup")
    @AndroidFindBy(id = "com.matrixx.android:id/btn_top_up")
    private MobileElement topupButtonElement;

    public OBPaymentCurrentBalanceScreen(AppiumDriver driver) {
        super(driver);
    }

    @Step
    public void topup() {
        wait.until(ExpectedConditions.elementToBeClickable(topupButtonElement));
        topupButtonElement.click();
    }
}

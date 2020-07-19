package stepdefs.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OBPlanSelectionScreen extends BaseScreen {

    @iOSXCUITFindBy(accessibility = "continue")
    @AndroidFindBy(id = "com.matrixx.android:id/fab")
    private MobileElement saveButtonElement;

    @iOSXCUITFindBy(accessibility = "data-2")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[3]")
    private MobileElement choice2GBElement;

    public OBPlanSelectionScreen(AppiumDriver driver) {
        super(driver);
    }

    @Step
    public void select2GBDataAndSave() {
        wait.until(ExpectedConditions.elementToBeClickable(choice2GBElement));

        choice2GBElement.click();
        saveButtonElement.click();
    }

}

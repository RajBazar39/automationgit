package stepdefs.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import stepdefs.AppiumController;

import java.io.FileNotFoundException;

public class MyPageScreen extends BaseScreen {

    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement okButtonAlertElement;

    @iOSXCUITFindBy(accessibility = "MORE")
    @AndroidFindBy(accessibility = "Navigate up")
    private MobileElement menuButtonElement;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='MY PAGE']")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'MY PAGE')]")
    private MobileElement myPageElement;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Adjust')]")
    private MobileElement adjstElement;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Top Up')]")
    private MobileElement topUpElement;

    @AndroidFindBy(id = "com.matrixx.android:id/overflow")
    private MobileElement thDotsBttn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MATRIXX\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]\n")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.TextView[2]")
    private MobileElement logoutButtonElement;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.CheckBox")
    private MobileElement reprovisionCheckboxElement;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement logoutPopupButtonElement;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='LOGOUT']")
    private MobileElement logoutMenuIOS;

    @AndroidFindBy(accessibility = "Navigate up")
    private MobileElement backButton;

    public MyPageScreen(AppiumDriver driver) {
        super(driver);
    }

    private MobileElement getTarrifPopupDataElement(String val) {
        MobileElement dataElement  = (MobileElement) driver.findElement((MobileBy.xpath("//android.widget.FrameLayout[1]//android.widget.TextView[contains(@text,'"+val+"')]")));
        return dataElement;
    }

    private MobileElement getTarrifPopupSmsElement(String val) {
        MobileElement smsElement  = (MobileElement) driver.findElement((MobileBy.xpath("//android.widget.FrameLayout[2]//android.widget.TextView[contains(@text,'"+val+"')]")));
        return smsElement;
    }

    private MobileElement getTarrifPopupVoiceElement(String val) {
        MobileElement voiceElement  = (MobileElement) driver.findElement((MobileBy.xpath("//android.widget.FrameLayout[3]//android.widget.TextView[contains(@text,'"+val+"')]")));
        return voiceElement;
    }

    @Step("Reprovisioning subscriber from MyPage")
    public void reprovision() {
        if (AppiumController.isPlatformIOS()) {
            wait.until(ExpectedConditions.elementToBeClickable(okButtonAlertElement));
            okButtonAlertElement.click();
        }

        wait.until(ExpectedConditions.elementToBeClickable(menuButtonElement));
        menuButtonElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutButtonElement));
        logoutButtonElement.click();

        if (AppiumController.isPlatformANDROID()) {
            wait.until(ExpectedConditions.elementToBeClickable(reprovisionCheckboxElement));
            reprovisionCheckboxElement.click();
            logoutPopupButtonElement.click();
        }
    }

    @Step
    public void logout() {
        if (AppiumController.isPlatformIOS()) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(okButtonAlertElement));
                okButtonAlertElement.click();
            } catch (Exception e) {}
        }
        wait.until(ExpectedConditions.elementToBeClickable(menuButtonElement));
        menuButtonElement.click();
        if (AppiumController.isPlatformANDROID()) {
            wait.until(ExpectedConditions.elementToBeClickable(logoutButtonElement));
            logoutButtonElement.click();
            wait.until(ExpectedConditions.elementToBeClickable(logoutPopupButtonElement));
            logoutPopupButtonElement.click();
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(logoutMenuIOS));
            logoutMenuIOS.click();
        }
    }

    @Step
    public void verifyMyPageElement() throws FileNotFoundException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(myPageElement));
            Assert.assertEquals(myPageElement.isDisplayed(), true);
        } catch (Exception e) {
            embedScreenshot("My Page Screen");
            Assert.fail(e.getMessage().toString());
        }
    }

    @Step
    public void clickAdjustBttn() throws FileNotFoundException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(thDotsBttn));
            thDotsBttn.click();
            wait.until(ExpectedConditions.elementToBeClickable(adjstElement));
            adjstElement.click();
        } catch (Exception e) {
            embedScreenshot("My Page Screen");
            Assert.fail(e.getMessage().toString());
        }
    }

    @Step
    public void clickBackButton() throws FileNotFoundException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(backButton));
            backButton.click();
        } catch (Exception e) {
            embedScreenshot("back button");
            Assert.fail(e.getMessage().toString());
        }
    }

    @Step
    public void clickTopupBttn() throws FileNotFoundException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(thDotsBttn));
            thDotsBttn.click();
            wait.until(ExpectedConditions.elementToBeClickable(topUpElement));
            topUpElement.click();
        } catch (Exception e) {
            embedScreenshot("My Page Screen");
            Assert.fail(e.getMessage().toString());
        }
    }

    @Step
    public void setTarrifTopupData(String val) throws FileNotFoundException {
        try {
            MobileElement dataElement = getTarrifPopupDataElement(val);
            wait.until(ExpectedConditions.elementToBeClickable(dataElement));
            dataElement.click();
        } catch (Exception e) {
            embedScreenshot("Select Tarrif-Topup Screen");
            Assert.fail(e.getMessage().toString());
        }
    }

    @Step
    public void setTarrifTopupSms(String val) throws FileNotFoundException {
        try {
            MobileElement smsElement = getTarrifPopupSmsElement(val);
            wait.until(ExpectedConditions.elementToBeClickable(smsElement));
            smsElement.click();
        } catch (Exception e) {
            embedScreenshot("Select Tarrif-Topup Screen");
            Assert.fail(e.getMessage().toString());
        }
    }

    @Step
    public void setTarrifTopupVoice(String val) throws FileNotFoundException {
        try {
            MobileElement voiceElement = getTarrifPopupVoiceElement(val);
            wait.until(ExpectedConditions.elementToBeClickable(voiceElement));
            voiceElement.click();
        } catch (Exception e) {
            embedScreenshot("Select Tarrif-Topup Screen");
            Assert.fail(e.getMessage().toString());
        }
    }
}
package stepdefs;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.CucumberOptions;

import java.io.FileNotFoundException;

public class MyPageSteps {

    @Then("^User adjust the base tariff as Data \"(.*)\" SMS \"(.*)\" VOICE \"(.*)\"$")
    public void set_tarrif_data_sms_voice(String data,String sms,String voice) throws InterruptedException, FileNotFoundException {
        //Click Adjust button
        AppiumController.myPageScreen.clickAdjustBttn();

        //Set Data Tarrif
        AppiumController.myPageScreen.setTarrifTopupData(data);

        //Set SMS Tarrif
        AppiumController.myPageScreen.setTarrifTopupSms(sms);

        //Set Voice Tarrif
        AppiumController.myPageScreen.setTarrifTopupVoice(voice);

        //Click back button
        AppiumController.myPageScreen.clickBackButton();

        //Verify my page screen
        AppiumController.myPageScreen.verifyMyPageElement();

        //Logout user
        AppiumController.myPageScreen.logout();

        //Verify landing page
        AppiumController.obLandingScreen.confirmLandingCurrentlyDisplayed();
    }

    @Then("^User choose to Top Up Tariff Bundle as Data \"(.*)\" SMS \"(.*)\" VOICE \"(.*)\"$")
    public void set_topup_data_sms_voice(String data,String sms,String voice) throws InterruptedException, FileNotFoundException {
        //Click Adjust button
        AppiumController.myPageScreen.clickTopupBttn();

        //Set Data Topup
        AppiumController.myPageScreen.setTarrifTopupData(data);

        //Set SMS Topup
        AppiumController.myPageScreen.setTarrifTopupSms(sms);

        //Set Voice Topup
        AppiumController.myPageScreen.setTarrifTopupVoice(voice);

        //Click back button
        AppiumController.myPageScreen.clickBackButton();

        //Verify my page screen
        AppiumController.myPageScreen.verifyMyPageElement();

        //Logout user
        AppiumController.myPageScreen.logout();

        //Verify landing page
        AppiumController.obLandingScreen.confirmLandingCurrentlyDisplayed();
    }

}

package stepdefs;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.CucumberOptions;

import java.io.FileNotFoundException;

public class LoginSteps {

    @Then("User logs in with invalid credentials")
    public void user_login_invalid_id() throws InterruptedException, FileNotFoundException {

        //Sign in
        AppiumController.obLandingScreen.acceptTCAndSignin();

    }

    @Then("User gets error message")
    public void user_error_message() throws InterruptedException, FileNotFoundException {

        //Enter Invalid Number and verify message
        AppiumController.loginScreen.enterInvalidLoginUserID();
    }

    @Given("App is installed and launched and user logged out")
    public void user_onboards_completing_survey_wLogout() throws InterruptedException {
        // Landing
        AppiumController.obLandingScreen.acceptTCAndSignup();

        // Tour
        // TODO: Handle optional step
        AppiumController.obTourScreen.skipTour();

        // Choose Plan
        AppiumController.obPlanSelectionScreen.select2GBDataAndSave();

        // Plan Confirmation
        AppiumController.obPlanConfirmationScreen.startSurvey();

        // Survey
        AppiumController.obSurveyScreen.completeSurvey();

        AppiumController.obPlanConfirmationScreen.rejectRecommendedOffers();
        AppiumController.obPlanEditScreen.continueActivation();

        // Onboarding flow (the order of onboarding steps) diverts here between iOS and Android
        if (AppiumController.isPlatformANDROID()) {
            // Phone Number
            AppiumController.obPhoneNumberScreen.inputPhoneNumberAndContinue();

            // SMS Confirmation
            AppiumController.obSmsConfirmationScreen.useDummySmsCode();

            // Registration
            AppiumController.obRegistrationScreen.registerDummySubscriber();

        } else if (AppiumController.isPlatformIOS()) {

            // Registration
            AppiumController.obRegistrationScreen.registerDummySubscriber();

            // Phone Number
            AppiumController.obPhoneNumberScreen.inputPhoneNumberAndContinue();

            // SMS Confirmation
            AppiumController.obSmsConfirmationScreen.useDummySmsCode();
        }
        // Payment Options
        AppiumController.obPaymentOptionsScreen.selectVoucher();

        // Payment Current Balance
        AppiumController.obPaymentCurrentBalanceScreen.topup() ;

        // Voucher
        AppiumController.obPaymentVoucherScreen.topUpUsingDummyVoucher();

        // Payment Topup
        AppiumController.obPaymentTopupScreen.topup();

        // Welcome
        AppiumController.obWelcomeScreen.continueToMyPage();

        // Logout
        AppiumController.myPageScreen.logout();
    }

    @Then("User logs in with correct credentials")
    public void user_login_valid_id() throws InterruptedException, FileNotFoundException {

        //Sign in
        AppiumController.obLandingScreen.clickSignIN();

        //Enter valid ID
        AppiumController.loginScreen.enterValidLoginUserID();

        //Verify MyPage
        AppiumController.myPageScreen.verifyMyPageElement();

        // Logout
        AppiumController.myPageScreen.logout();

    }

    @Given("App is installed and launched and user logged in")
    public void user_login() throws InterruptedException, FileNotFoundException {
        // Landing
        AppiumController.obLandingScreen.acceptTCAndSignin();

       //Login User
        AppiumController.loginScreen.enterValidLoginUserID();

        //Verify MyPage
        AppiumController.myPageScreen.verifyMyPageElement();

    }

    @When("User on My page screen")
    public void verify_mypage() throws InterruptedException, FileNotFoundException {
        //Verify MyPage
        AppiumController.myPageScreen.verifyMyPageElement();
    }
}

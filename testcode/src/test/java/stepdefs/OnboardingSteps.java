package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OnboardingSteps {

    @Given("App is installed and launched")
    public void app_is_installed_and_launched() {
        AppiumController.obLandingScreen.confirmLandingCurrentlyDisplayed();
    }

    @When("User onboards skipping survey")
    public void user_onboards_skipping_survey() throws InterruptedException {
        // Landing
        AppiumController.obLandingScreen.acceptTCAndSignup();

        // Tour
        // TODO: Handle optional step
        AppiumController.obTourScreen.skipTour();

        // Choose Plan
        AppiumController.obPlanSelectionScreen.select2GBDataAndSave();

        // Plan Confirmation
        AppiumController.obPlanConfirmationScreen.continueActivation();

        // Onboarding flow (the order of onboarding steps) diverts here between iOS and Android
        if (AppiumController.isPlatformANDROID()) {
            // Phone Number
            AppiumController.obPhoneNumberScreen.inputPhoneNumberAndContinue();

            // SMS Confirmation
            AppiumController.obSmsConfirmationScreen.useDummySmsCode();

            // Registration
            AppiumController.obRegistrationScreen.registerDummySubscriber();

        } else if (AppiumController.isPlatformIOS()) {
            // Activate your account - Android equivalent?
            AppiumController.obPlanEditScreen.continueActivation();

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

        // MyPage
        AppiumController.myPageScreen.reprovision();
    }

    @When("User onboards completing survey")
    public void user_onboards_completing_survey() throws InterruptedException {
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

        // MyPage
        AppiumController.myPageScreen.reprovision();
    }

    @Then("User reaches home screen")
    public void user_reaches_home_screen() throws InterruptedException {
        AppiumController.obLandingScreen.confirmLandingCurrentlyDisplayed();
    }
}

package stepdefs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import stepdefs.screens.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;

public class AppiumController {

    private static final String BUILD_NAME_ANDROID = "demoapp-release.apk";
    private static final String BUILD_NAME_IOS = "Matrixx Mobile.app";
    public static final String PHONE_NUMBER = "447884443373";
    public static final String PLATFORM_ANDROID = "android";
    public static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_DEFAULT = PLATFORM_IOS;
    private static int PORT_ANDROID = 4726;
    private static int PORT_IOS = 4725;

    // PageObject Model Screens with element identifiers and screen specific logic
    public static OBLandingScreen obLandingScreen;
    public static OBTourScreen obTourScreen;
    public static OBPlanSelectionScreen obPlanSelectionScreen;
    public static OBPlanConfirmationScreen obPlanConfirmationScreen;
    public static OBSurveyScreen obSurveyScreen;
    public static OBPlanEditScreen obPlanEditScreen;
    public static OBPhoneNumberScreen obPhoneNumberScreen;
    public static OBSMSConfirmationScreen obSmsConfirmationScreen;
    public static OBRegistrationScreen obRegistrationScreen;
    public static OBPaymentOptionsScreen obPaymentOptionsScreen;
    public static OBPaymentCurrentBalanceScreen obPaymentCurrentBalanceScreen;
    public static OBPaymentVoucherScreen obPaymentVoucherScreen;
    public static OBPaymentTopupScreen obPaymentTopupScreen;
    public static OBWelcomeScreen obWelcomeScreen;
    public static MyPageScreen myPageScreen;
    public static LoginScreen loginScreen;

    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    private DesiredCapabilities cap;
    private AppiumDriver driver;

    public AppiumDriver getDriver() {
        return driver;
    }

    @Before
    public void setup() {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/apps");
        cap = new DesiredCapabilities();
        System.out.println("PLATFORM: " + getPlatform());
        switch (getPlatform()) {
            case PLATFORM_ANDROID:
                // Set Capabilities
                File androidApp = new File(appDir, "/" + BUILD_NAME_ANDROID);
                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
                cap.setCapability(MobileCapabilityType.APP, androidApp.getAbsolutePath());
//                cap.setCapability("avd", "Pixel_2_API_28");
                cap.setCapability("avd", "Pixel_3a_API_28");
                cap.setCapability("appPackage", "com.matrixx.android");
                cap.setCapability("appActivity", ".activity.SplashActivity");
                cap.setCapability("allowTestPackages", "true");
                cap.setCapability("autoGrantPermissions",true);
                //cap.setCapability("noReset",true);

                // Build the Appium service
                builder = new AppiumServiceBuilder();
                builder.withIPAddress("127.0.0.1");
                builder.usingPort(PORT_ANDROID);
                builder.withCapabilities(cap);
                builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
                builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

                // Start the server with the builder
                service = AppiumDriverLocalService.buildService(builder);
                service.start();

                // Start Driver
                try {
                    URL url = new URL("http://localhost:" + PORT_ANDROID + "/wd/hub");
                    driver = new AndroidDriver(url, cap);
                    System.out.println("Appium Android Driver created...");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;

            case PLATFORM_IOS:
                // Set Capabilities
                File iOSApp = new File(appDir, "/" + BUILD_NAME_IOS);
                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//                cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
//                cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11 Pro Max");
                cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.3");
                cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                cap.setCapability(MobileCapabilityType.NO_RESET, "false");
//                cap.setCapability(MobileCapabilityType.APP, "/Users/eduardo/Documents/workspace/waverley/_RELEASES/iOS/removeme/Matrixx Mobile.app");
                cap.setCapability(MobileCapabilityType.APP, iOSApp.getAbsolutePath());
//                cap.setCapability(MobileCapabilityType.UDID, "a8446554c669a0305f97f342273b77231ae4b5e5");
//                cap.setCapability("xcodeOrgId", "7F8SLH447S");
//                cap.setCapability("xcodeSigningId", "iPhone Developer");

                // Build the Appium service
                builder = new AppiumServiceBuilder();
                builder.withIPAddress("127.0.0.1");
                builder.usingPort(PORT_IOS);
                builder.withCapabilities(cap);
                builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
                builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

                // Start the server with the builder
                service = AppiumDriverLocalService.buildService(builder);
                service.start();

                // Start Driver
                try {
                    URL url = new URL("http://localhost:" + PORT_IOS + "/wd/hub");
                    driver = new IOSDriver(url, cap);
                    System.out.println("Appium iOS Driver created...");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;

            default:

        }

        initScreens(driver);
    }

    /**
     * Initialises PageObject Model screens
     * @param driver to be used internally in the PageObject Model screens
     */
    private void initScreens(AppiumDriver driver) {
        obLandingScreen = new OBLandingScreen(driver);
        obTourScreen = new OBTourScreen(driver);
        obPlanSelectionScreen = new OBPlanSelectionScreen(driver);
        obPlanConfirmationScreen = new OBPlanConfirmationScreen(driver);
        obSurveyScreen = new OBSurveyScreen(driver);
        obPlanEditScreen = new OBPlanEditScreen(driver);
        obPhoneNumberScreen = new OBPhoneNumberScreen(driver);
        obSmsConfirmationScreen = new OBSMSConfirmationScreen(driver);
        obRegistrationScreen = new OBRegistrationScreen(driver);
        obPaymentOptionsScreen = new OBPaymentOptionsScreen(driver);
        obPaymentCurrentBalanceScreen = new OBPaymentCurrentBalanceScreen(driver);
        obPaymentVoucherScreen = new OBPaymentVoucherScreen(driver);
        obPaymentTopupScreen = new OBPaymentTopupScreen(driver);
        obWelcomeScreen = new OBWelcomeScreen(driver);
        myPageScreen = new MyPageScreen(driver);
        loginScreen = new LoginScreen(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
        service.stop();
    }

    /**
     * Helper method to identify if port Appium is already running in a given port.
     * Use as: steps.BaseTest.checkIfServerIsRunnning(port)
     * @param port To inspect if has Appium running.
     * @return boolean indicating if Appiumn is running in the given port.
     */
    public boolean checkIfServerIsRunnning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            // If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    /**
     * Provides the platform under test 'android' or 'ios'
     * @return Platform to test
     */
    public static String getPlatform() {
        // Getting the platform from the environment variable
        String platform = System.getenv("PLATFORM");
        if (platform == null) {
            System.out.println("Using default PLATFORM: " + PLATFORM_DEFAULT);
            return PLATFORM_DEFAULT;
        }
        return platform;
    }

    /**
     * Convenience getter to check if platform is iOS and help with readability
     * @return true if the Platform is iOS
     */
    public static boolean isPlatformIOS() {
        return getPlatform().equals(PLATFORM_IOS);
    }

    /**
     * Convenience getter to check if platform is Android and help with readability
     * @return true if the Platform is Android
     */
    public static boolean isPlatformANDROID() {
        return getPlatform().equals(PLATFORM_ANDROID);
    }
}

package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import webDriver.WebDriverBuilder;

import java.io.IOException;

/**
 * Created by Bharathan on 11/02/16.
 * Created on 11/02/16 7:41 PM
 */
public class Hooks extends BaseSteps {

    String apkPath = System.getProperty("user.dir")+"/apk/android-debug.apk";
    String launchApp = "adb install "+apkPath;
    Process appium;
    @Before
    public void setUp() throws IOException {
        appium = Runtime.getRuntime().exec("/usr/local/bin/appium");
        appium = Runtime.getRuntime().exec("emulator -avd AVD_for_Galaxy_Nexus_Customised");
        appium = Runtime.getRuntime().exec(launchApp);
        System.out.println("@before started");
        driverSteps = WebDriverBuilder.getAndroidWebDriver();
    }

    @After
    public void tearDown() {
        System.out.println("@after started");
        driverSteps.closeApp();
        driverSteps.quit();
        WebDriverBuilder.nullAndroidWebDriver();
//        appium.destroy();
    }

}

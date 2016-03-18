package webDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Bharathan on 01/02/16.
 * Created on 01/02/16 8:13 PM
 */
public class WebDriverBuilder {
    static AppiumDriver<WebElement> driver;
    static DesiredCapabilities capabilities;

    public static AppiumDriver getAndroidWebDriver() {
//        if ((driver == null) && (capabilities == null)) {
//            capabilities = new DesiredCapabilities();
//            capabilities.setCapability("deviceName", "AVD_for_Galaxy_Nexus_Customised");
//            try {
//                driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//            } catch (MalformedURLException e) {
//                System.out.println("Driver creation issues");
//                e.printStackTrace();
//            }
//        }
//        return driver;
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"4.4");
        capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/apk/android-debug.apk");
        capabilities.setCapability(MobileCapabilityType.APP_PACKAGE,"com.ionicframework.starter");
        capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY,".MainActivity");
        try {
            return driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static void nullAndroidWebDriver() {

        driver = null;
        capabilities = null;
    }
}

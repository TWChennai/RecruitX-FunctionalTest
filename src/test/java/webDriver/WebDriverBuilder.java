package webDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Bharathan on 01/02/16.
 * Created on 01/02/16 8:13 PM
 */
public class WebDriverBuilder {
    public static AppiumDriver<WebElement> driverBuilder;

    public static DesiredCapabilities capabilities;

    public static AppiumDriver getAndroidWebDriver() throws MalformedURLException {
        if ((driverBuilder == null) && (capabilities == null)) {
            capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"4.4");
            capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/apk/android-debug.apk");
            capabilities.setCapability(MobileCapabilityType.APP_PACKAGE,"com.ionicframework.starter");
            capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY,".MainActivity");
            driverBuilder = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            }
        return driverBuilder;
    }



    public static void nullAndroidWebDriver() {

        driverBuilder = null;
        capabilities = null;
    }
}

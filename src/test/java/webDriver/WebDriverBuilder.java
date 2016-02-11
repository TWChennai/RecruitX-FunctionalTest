package webDriver;

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
    static RemoteWebDriver driver;
    static File classpathRoot; // path to Eclipse project
    static File appDir; // path to <project folder>/Contact Manager
    static File app; //path to <project folder>/Contact Manager/ContactManager.apk
    static DesiredCapabilities capabilities;

    public static RemoteWebDriver getWebDriver() {
        if (driver == null) {
            classpathRoot = new File(System.getProperty("user.dir"));
            appDir = new File(classpathRoot, "/ContactManager");
            app = new File(appDir, "ContactManager.apk");
            capabilities = new DesiredCapabilities();
            capabilities.setCapability(CapabilityType.BROWSER_NAME, ""); //Name of mobile web browser to automate. Should be an empty string if automating an app instead.
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability(CapabilityType.VERSION, "4.4.4");
            capabilities.setCapability("deviceName", "AVD_for_Galaxy_Nexus_Customised");
            capabilities.setCapability("app", app.getAbsolutePath());
            capabilities.setCapability("appPackage", "com.example.android.contactmanager");
            capabilities.setCapability("appActivity", ".ContactManager");
            try {
                driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                System.out.println("Error in driver instatiation");
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static RemoteWebDriver getAndroidWebDriver() {
        if ((driver == null) && (capabilities == null)) {
            capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "AVD_for_Galaxy_Nexus_Customised");
            try {
                driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                System.out.println("Driver creation issues");
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void nullWebDriver() {
        driver = null;
    }

    public static void nullAndroidWebDriver() {

        driver = null;
        capabilities = null;
    }
}

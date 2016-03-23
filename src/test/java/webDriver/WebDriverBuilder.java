package webDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.AvailabelPorts;

import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * Created by Bharathan on 01/02/16.
 * Created on 01/02/16 8:13 PM
 */
public class WebDriverBuilder {
    public AppiumDriver<MobileElement> driverBuilder;
    public DesiredCapabilities capabilities;
    AppiumDriverLocalService appiumDriverLocalService;
    public Properties prop = new Properties();
    public InputStream input = null;
    AvailabelPorts ap = new AvailabelPorts();
    static Process p;


    public AppiumDriver getAndroidWebDriver() throws Exception {
        input = new FileInputStream("config.properties");
        prop.load(input);
        appiumServer();
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
        capabilities.setCapability(MobileCapabilityType.APP,prop.getProperty("APP_PATH"));
        capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, prop.getProperty("APP_PACKAGE"));
        capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, prop.getProperty("APP_ACTIVITY"));
        driverBuilder = new AndroidDriver<MobileElement>(getAppiumUrl(), capabilities);

        return driverBuilder;
    }

    public AppiumServiceBuilder appiumServer() throws Exception {
        System.out.println("Starting Appium Server Android");
        input = new FileInputStream("config.properties");
        prop.load(input);
        int port = ap.getPort();
        int chromePort = ap.getPort();
        int bootstrapPort = ap.getPort();
        int selendroidPort = ap.getPort();
        System.out.println("BootStrapPort" + bootstrapPort);
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(new File(prop.getProperty("APPIUM_JS_PATH")))
                .withArgument(GeneralServerFlag.CHROME_DRIVER_PORT, Integer.toString(chromePort))
                .withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, Integer.toString(bootstrapPort))
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(AndroidServerFlag.SUPPRESS_ADB_KILL_SERVER)
                .withArgument(AndroidServerFlag.SELENDROID_PORT, Integer.toString(selendroidPort)).usingPort(port);
        appiumDriverLocalService = builder.build();
        appiumDriverLocalService.start();
        return builder;

    }

    public URL getAppiumUrl() {
        return appiumDriverLocalService.getUrl();
    }

    public void destroyAppiumServer(){
        appiumDriverLocalService.stop();
    }


    public void nullAndroidWebDriver() {
        driverBuilder = null;
        capabilities = null;
    }




    public String runCommand(String command) throws InterruptedException, IOException {
        p = Runtime.getRuntime().exec(command);
        // get std output
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        String allLine = "";
        int i = 1;
        while ((line = r.readLine()) != null) {
/*			if (line.isEmpty()) {
				break;
			}*/
            allLine = allLine + "" + line + "\n";
            System.out.println(allLine);
            if (line.contains("Console LogLevel: debug") && line.contains("Complete"))
                break;
            i++;
        }
        return allLine;

    }
}

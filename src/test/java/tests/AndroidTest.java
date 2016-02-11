package tests; /**
 * Created by Bharathan on 10/02/16.
 * Created on 10/02/16 12:29 AM
 */
//used to verify if URL is malformed

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidTest {
    public WebDriver driver;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]")
    private WebElement loginHeader;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[2]")
    private WebElement userNameTextBox;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[3]")
    private WebElement passWordTextBox;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[1]/android.widget.Button[1]")
    private WebElement submit;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[5]")
    private WebElement serverAuthenticationError;

    private WebElement loginHeader() {
        return driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]"));
    }

    private WebElement userNameTextBox() {
        return driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[2]"));
    }

    private WebElement passWordTextBox() {
        return driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[3]"));
    }

    private WebElement submit() {
        return driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[1]/android.widget.Button[1]"));
    }

    public AndroidTest() {
        PageFactory.initElements(driver, this);
    }

    @Before
    public void setUp() throws MalformedURLException {
        System.out.println("@before started");

//        File classpathRoot = new File(System.getProperty("user.dir")); // path to Eclipse project
//        File appDir = new File(classpathRoot, "/recruitx_APK"); // path to <project folder>/Contact Manager
//        File app = new File(appDir, "android-debug.apk"); //path to <project folder>/Contact Manager/ContactManager.apk
        /*DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(CapabilityType.BROWSER_NAME, ""); //Name of mobile web browser to automate. Should be an empty string if automating an app instead.
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability(CapabilityType.VERSION, "4.4.4");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
        capabilities.setCapability("appActivity", ".ContactManager");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);*/
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium

        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("BROWSER_NAME", "Android");
//        capabilities.setCapability("VERSION", "4.4.2");
        capabilities.setCapability("deviceName", "AVD_for_Galaxy_Nexus_Customised");
//        capabilities.setCapability("platformName", "Android");

//        capabilities.setCapability("appPackage", "com.android.calculator2");
// This package name of your app (you can get it from apk info app)
//        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator"); // This is Launcher activity of your app (you can get it from apk info app)
//Create RemoteWebDriver instance and connect to the Appium server
        //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @Test
    public void addContact() throws Exception {
        userNameTextBox().click();
        userNameTextBox().sendKeys("bharathk@thoughtworks.com");
        userNameTextBox().sendKeys(Keys.ADD);

        passWordTextBox().click();
        passWordTextBox().sendKeys("!abcd1234");
        submit().click();
    }

}

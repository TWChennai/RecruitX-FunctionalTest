package tests; /**
 * Created by Bharathan on 10/02/16.
 * Created on 10/02/16 12:29 AM
 */
//used to verify if URL is malformed

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class AndroidTest {
    public AppiumDriver<WebElement> driver;

    private WebElement userNameTextBox() {
        return driver.findElement(By.xpath(".//*[@name='username']"));
    }

    private WebElement passWordTextBox() {
        return driver.findElement(By.name("password"));
    }

    private WebElement submit() {
        return driver.findElement(By.xpath(".//*[@value='Sign In']"));
    }

    public AndroidTest() {
        PageFactory.initElements(driver, this);
    }

    @Before
    public void setUp() throws MalformedURLException {
        System.out.println("@before started");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.0.X");
        capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/apk/android-debug.apk");
        capabilities.setCapability(MobileCapabilityType.APP_PACKAGE,"com.ionicframework.starter");
        capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY,".MainActivity");
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @Test
    public void addContact() throws Exception {
        Thread.sleep(5000);
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        driver.context("WEBVIEW_com.thoughtworks.recruitx");
        System.out.println(driver.getPageSource());
        userNameTextBox().click();
        userNameTextBox().sendKeys("bharathk@thoughtworks.com");
        passWordTextBox().click();
        passWordTextBox().sendKeys("!abcd1234");
        submit().click();
    }

}

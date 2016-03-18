package tests; /**
 * Created by Bharathan on 10/02/16.
 * Created on 10/02/16 12:29 AM
 */
//used to verify if URL is malformed

import com.thoughtworks.selenium.Selenium;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

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
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"4.4");
        capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/apk/android-debug.apk");
        capabilities.setCapability(MobileCapabilityType.APP_PACKAGE,"com.ionicframework.starter");
        capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY,".MainActivity");
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @Test
    public void addContact() throws Exception {
//        WebDriverWait wait = new WebDriverWait(driver,60);
//        wait.until(userNameTextBox().isDisplayed());
        Thread.sleep(20000);
        List<String> contextNameStringList = new ArrayList<String>();
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        contextNameStringList.addAll(contextNames);
        driver.context(contextNameStringList.get(1));
        System.out.println(driver.getPageSource());
        userNameTextBox().click();
        userNameTextBox().sendKeys("bharathk@thoughtworks.com");
        passWordTextBox().click();
        passWordTextBox().sendKeys("!abcd1234");
        submit().click();
    }

    @After
    public void tearDown(){
        System.out.println("@after started");
        driver.closeApp();
        driver.quit();
    }

}

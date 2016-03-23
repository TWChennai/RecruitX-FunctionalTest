package tests; /**
 * Created by Bharathan on 10/02/16.
 * Created on 10/02/16 12:29 AM
 */
//used to verify if URL is malformed

import io.appium.java_client.AppiumDriver;
import org.fest.assertions.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.WebDriverBuilder;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AndroidTest {
    public AppiumDriver<WebElement> driver;
    public DesiredCapabilities capabilities;

    private WebElement userNameTextBox() {
        return driver.findElement(By.xpath(".//*[@name='username']"));
    }

    private WebElement passWordTextBox() {
        return driver.findElement(By.name("password"));
    }

    private WebElement submit() {
        return driver.findElement(By.xpath(".//*[@value='Sign In']"));
    }

    private WebElement homePageTitle() {
        return driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]"));
    }

    private WebElement enterExperience() {
        return driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[8]/android.widget.EditText[1]"));
    }

    public AndroidTest() {
        PageFactory.initElements(driver, this);
    }

    @Before
    public void setUp() throws MalformedURLException {
        System.out.println("@before started");
//        capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
//        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/apk/android-debug.apk");
//        capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.ionicframework.starter");
//        capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, ".MainActivity");
//        driverBuilder = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver = WebDriverBuilder.getAndroidWebDriver();
    }

    @Test
    public void addContact() throws Exception {
//        WebDriverWait wait = new WebDriverWait(driverBuilder,60);
//        wait.until(userNameTextBox().isDisplayed());
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.elementToBeClickable(By
//                .xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[2]")));
        List<String> contextNameStringList = new ArrayList<String>();
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        contextNameStringList.addAll(contextNames);
        driver.context(contextNameStringList.get(1));
        userNameTextBox().click();
        userNameTextBox().sendKeys("ppanelist");
        passWordTextBox().click();
        passWordTextBox().sendKeys("P@ssw0rd");
        submit().click();
//        enterExperience().click();
//        enterExperience().sendKeys("1");
//        wait.until(ExpectedConditions.elementToBeClickable(homePageTitle()));
//        Assertions.assertThat(homePageTitle().getText().contains("Hi panelist"));
}

    @After
    public void tearDown() {
        System.out.println("@after started");
//        driverBuilder.closeApp();
//        driverBuilder.quit();
        WebDriverBuilder.nullAndroidWebDriver();
    }

}

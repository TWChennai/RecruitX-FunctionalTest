package tests; /**
 * Created by Bharathan on 10/02/16.
 * Created on 10/02/16 12:29 AM
 */
//used to verify if URL is malformed

import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import webDriver.WebDriverBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AndroidTest {
    public AppiumDriver<WebElement> driver;
    public DesiredCapabilities capabilities;
    WebDriverBuilder webDriverBuilder = new WebDriverBuilder();
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
    public void setUp() throws Exception {
        System.out.println("@before started");
        driver = webDriverBuilder.getAndroidWebDriver();
    }

    @Test
    public void addContact() throws Exception {
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
}

    @After
    public void tearDown() {
        System.out.println("@after started");
//        driverBuilder.closeApp();
//        driverBuilder.quit();
        webDriverBuilder.nullAndroidWebDriver();
    }

}

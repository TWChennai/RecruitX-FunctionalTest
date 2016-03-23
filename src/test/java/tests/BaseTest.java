package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.LoginPage;
import webDriver.WebDriverBuilder;

import java.net.MalformedURLException;

/**
 * Created by Bharathan on 10/02/16.
 * Created on 10/02/16 1:04 PM
 */
public class BaseTest {

    AppiumDriver<WebElement> driver;
    LoginPage lgnPage;
    public Logger logger;

    public BaseTest() throws MalformedURLException, InterruptedException {
        lgnPage = new LoginPage();
        logger = Logger.getLogger(BaseTest.class);
    }

    @Before
    public void setUp() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driverBuilder",
//                "/Users/Bharathan/Selenium/Driver/chromedriver");
//        driverBuilder = new ChromeDriver();
//        driverBuilder.get("http://accountsdemo.herokuapp.com");
////        login("bharathk@thoughtworks.com", "ARUNmozhi");
        driver = WebDriverBuilder.getAndroidWebDriver();

    }

    @After

    public void tearDown() {
//        driverBuilder.close();
        driver.quit();
        WebDriverBuilder.nullAndroidWebDriver();
    }
}

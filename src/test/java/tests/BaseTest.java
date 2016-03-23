package tests;

import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import webDriver.WebDriverBuilder;

/**
 * Created by Bharathan on 10/02/16.
 * Created on 10/02/16 1:04 PM
 */
public class BaseTest {

    AppiumDriver<WebElement> driver;
    LoginPage lgnPage;
    WebDriverBuilder webDriverBuilder = new WebDriverBuilder();
    public Logger logger;

    public BaseTest() throws Exception {
        lgnPage = new LoginPage();
        logger = Logger.getLogger(BaseTest.class);
    }

    @Before
    public void setUp() throws Exception {
        driver = webDriverBuilder.getAndroidWebDriver();
    }

    @After

    public void tearDown() {
//        driverBuilder.close();
        driver.quit();
        webDriverBuilder.nullAndroidWebDriver();
    }
}

package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import webDriver.WebDriverBuilder;

import java.net.MalformedURLException;

/**
 * Created by Bharathan on 01/02/16.
 * Created on 01/02/16 8:44 PM
 */
public class BasePage {
    public static AppiumDriver<WebElement> driverPage;


    public BasePage() throws MalformedURLException {
//        this.driverBuilder = WebDriverBuilder.getWebDriver();
        this.driverPage = WebDriverBuilder.getAndroidWebDriver();
    }
}

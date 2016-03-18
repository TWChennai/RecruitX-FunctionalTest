package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import webDriver.WebDriverBuilder;

import java.net.MalformedURLException;

/**
 * Created by Bharathan on 01/02/16.
 * Created on 01/02/16 8:44 PM
 */
public class BasePage {
    AppiumDriver<WebElement> driver;

    public BasePage() {
//        this.driver = WebDriverBuilder.getWebDriver();
        this.driver = WebDriverBuilder.getAndroidWebDriver();
    }
}

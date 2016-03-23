package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import webDriver.WebDriverBuilder;

/**
 * Created by Bharathan on 01/02/16.
 * Created on 01/02/16 8:44 PM
 */
public class BasePage {
    public AppiumDriver<WebElement> driverPage;
    WebDriverBuilder webDriverBuilder = new WebDriverBuilder();

    public BasePage() throws Exception {
//        this.driverBuilder = WebDriverBuilder.getWebDriver();
        this.driverPage = webDriverBuilder.getAndroidWebDriver();
    }
}

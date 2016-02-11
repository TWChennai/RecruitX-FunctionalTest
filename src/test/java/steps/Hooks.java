package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import webDriver.WebDriverBuilder;

import java.net.MalformedURLException;

/**
 * Created by Bharathan on 11/02/16.
 * Created on 11/02/16 7:41 PM
 */
public class Hooks extends BaseSteps {

    @Before
    public void setUp() throws MalformedURLException {
        System.out.println("@before started");
        driver = WebDriverBuilder.getAndroidWebDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
        WebDriverBuilder.nullAndroidWebDriver();
    }

}

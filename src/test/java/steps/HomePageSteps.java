package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;

import java.net.MalformedURLException;

/**
 * Created by Bharathan on 18/03/16.
 * Created on 18/03/16 4:39 PM
 */
public class HomePageSteps extends BaseSteps{

    public HomePage homePage;
    public HomePageSteps() throws MalformedURLException {
        homePage = new HomePage();
    }

    @Then("^I should see title as (.+)$")
    public void I_should_see_title_as(String title){
        // Express the Regexp above with the code you wish you had
        homePage.verifyTitle(title);
    }
}

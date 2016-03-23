package steps;

import cucumber.api.java.en.Then;
import pages.HomePage;

/**
 * Created by Bharathan on 18/03/16.
 * Created on 18/03/16 4:39 PM
 */
public class HomePageSteps extends BaseSteps{

    public HomePage homePage;
    public HomePageSteps() throws Exception {
        homePage = new HomePage();
    }

    @Then("^I should see title as (.+)$")
    public void I_should_see_title_as(String title){
        // Express the Regexp above with the code you wish you had
        homePage.verifyTitle(title);
    }
}

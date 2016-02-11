package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import pages.LoginPage;

/**
 * Created by Bharathan on 11/02/16.
 * Created on 11/02/16 7:41 PM
 */
public class LoginSteps extends BaseSteps {

    public LoginPage loginPage;
    public LoginSteps() {
        loginPage = new LoginPage();
    }

    @When("^I provide username as (.+)$")
    public void I_provide_username_as(String userName) throws Throwable {
        loginPage.setLogin(userName);
    }

    @When("^I provide password as (.+)$")
    public void I_provide_password_as_(String password) throws Throwable {
        // Express the Regexp above with the code you wish you had
        loginPage.setPassword(password);
    }

    @When("^I submit login$")
    public void I_submit_login() throws Throwable {
        // Express the Regexp above with the code you wish you had
        loginPage.clickSubmit();
    }
}

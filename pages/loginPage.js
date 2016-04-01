export default class LoginPage {
  constructor(driver, asserters) {
    this.driver = driver;
    this.asserters = asserters;
  }

  title() {
    return this.driver.context('WEBVIEW_com.thoughtworks.recruitx')
                      .waitForElementByCssSelector('.okta-form-title', this.asserters.isDisplayed, 60000, 10000).text();
  }

  enterUsername(username) {
    return this.driver.context('WEBVIEW_com.thoughtworks.recruitx')
                      .elementByName('username', 60000, 10000).type(username);
  }

  enterPassword(password) {
    return this.driver.context('WEBVIEW_com.thoughtworks.recruitx')
                      .elementByName('password', 60000, 10000).type(password);
  }

  clickSignIn() {
    return this.driver.context('WEBVIEW_com.thoughtworks.recruitx')
                      .elementByCss('input[value=\'Sign In\']').click();
  }

  enterExperience() {
    return this.driver.context('WEBVIEW_com.thoughtworks.recruitx')
                      .waitForElementByCssSelector('.ng-pristine', 3000, 1000).type('2');
  }

  clickDoneOnExperience() {
    return this.driver.context('WEBVIEW_com.thoughtworks.recruitx')
                      .elementByCss('.popup-buttons').click();
  }
}

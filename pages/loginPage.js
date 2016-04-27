import BasePage from './basePage';

export default class LoginPage extends BasePage {
  constructor(driver, asserters) {
    super(driver);
    this.asserters = asserters;
  }

  waitForLoginPageToLoad() {
    return this.switchToWebViewDriver()
               .waitForElementByCssSelector('.okta-form-title',
                  this.asserters.isDisplayed, 60000, 1000);
  }

  title() {
    return this.switchToWebViewDriver()
               .waitForElementByCssSelector('.okta-form-title',
                  this.asserters.isDisplayed, 60000, 10000).text();
  }

  getErrorMessage() {
    return this.switchToWebViewDriver()
                                .waitForElementByCssSelector('.o-form-error-container p',
                                  this.asserters.isDisplayed, 100000, 10000).text();
  }

  enterUsername(username) {
    return this.switchToWebViewDriver().elementByName('username', 60000, 10000).type(username);
  }

  enterPassword(password) {
    return this.switchToWebViewDriver().elementByName('password', 60000, 10000).type(password);
  }

  clickSignIn() {
    return this.switchToWebViewDriver().elementByCss('input[value=\'Sign In\']').click();
  }

  enterExperience(experience) {
    return this.switchToWebViewDriver().waitForElementByCssSelector('.ng-pristine', 3000, 1000)
               .type(experience);
  }

  clickDoneOnExperience() {
    return this.switchToWebViewDriver().elementByCss('.popup-buttons').click();
  }
}

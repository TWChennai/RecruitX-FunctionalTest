export default class BasePage {
  constructor(driver) {
    this.driver = driver;
  }

  switchToWebViewDriver() {
    return this.driver.context('WEBVIEW_com.thoughtworks.recruitx');
  }

  switchToNativeAppDriver() {
    return this.driver.context('NATIVE_APP');
  }

  getTitle() {
    return this.switchToWebViewDriver().
        waitForElementByCssSelector('div[nav-bar=\'active\'] .title',
                      this.asserters.isDisplayed, 20000, 1000).text();
  }

  getConfirmationMessage() {
    return this.switchToWebViewDriver().
    waitForElementByCssSelector('.popup-body',
                  this.asserters.isDisplayed, 20000, 1000).text();
  }

  async clickConfirm() {
    const buttons = await this.switchToWebViewDriver().
    waitForElementsByCssSelector('.button.ng-binding.button-positive');
    return buttons[1].click();
  }

  clickOk() {
    return this.switchToWebViewDriver().
    waitForElementByCssSelector('.button.ng-binding.button-positive').click();
  }
}

import BasePage from './basePage';

export default class HomePage extends BasePage {
  constructor(driver, asserters) {
    super(driver);
    this.asserters = asserters;
  }

  waitForHomePageToLoad() {
    return this.switchToWebViewDriver()
               .waitForElementByCssSelector('.ion-log-out', this.asserters.isDisplayed, 10000, 1000);
  }

  title() {
    return this.switchToWebViewDriver().elementByCss('.title').text();
  }
}

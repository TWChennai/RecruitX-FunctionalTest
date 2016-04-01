export default class HomePage {
  constructor(driver, asserters) {
    this.driver = driver;
    this.asserters = asserters;
  }

  waitForHomePageToLoad() {
    return this.driver.context('WEBVIEW_com.thoughtworks.recruitx')
                      .waitForElementByCssSelector('.ion-log-out', this.asserters.isDisplayed, 5000, 1000);
  }

  title() {
    return this.driver.context('WEBVIEW_com.thoughtworks.recruitx')
                      .elementByCss('.title').text();
  }
}

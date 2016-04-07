export default class BasePage {
  constructor(driver) {
    this.driver = driver;
  }

  switchToWebViewDriver() {
    return this.driver.context('WEBVIEW_com.thoughtworks.recruitx');
  }

  getTitle() {
    return this.switchToWebViewDriver().elementByCss('div[nav-bar=\'active\'] .title').text();
  }
}

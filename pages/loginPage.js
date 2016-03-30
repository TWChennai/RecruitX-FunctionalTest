export default class LoginPage {
  constructor(driver) {
    this.driver = driver;
  }

  waitForLoginPageToLoad() {
    return this.driver.waitForElementByClassName('android.webkit.WebView', 60000, 10000);
  }

  title() {
    return this.driver.waitForElementById('RecruitX Heading', 60000, 10000).text();
  }
}

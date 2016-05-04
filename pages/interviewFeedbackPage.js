import BasePage from './basePage';

export default class InterviewFaadbackPage extends BasePage {
  constructor(driver, asserters) {
    super(driver);
    this.asserters = asserters;
  }

  clickPursueLink() {
    return this.switchToWebViewDriver().waitForElementByLinkText(
      'Pursue', this.asserters.isDisplayed, 20000, 1000).click();
    // .elementByLinkText('Pursue').click();
  }

  clickCameraIcon() {
    return this.switchToWebViewDriver().elementByCssSelector('.ion-camera').click();
  }

  async captureCameraImage() {
    const driver = this.switchToNativeAppDriver();
    await driver.pressDeviceKey(27);
    // return driver.waitForElementById(
    // 'com.android.gallery3d:id/btn_done', that.asserters.isDisplayed, 30000, 1000).click();
    // Specifc to android Emulator
    return driver.waitForElementById(
      'com.android.camera:id/btn_done', this.asserters.isDisplayed, 30000, 1000).click();
  }

  clickSubmitButton() {
    return this.switchToWebViewDriver()
               .waitForElementByCss(
                 'button[ng-click=\'saveFeedback()\']',
                 this.asserters.isDisplayed, 10000, 1000).click();
  }
}

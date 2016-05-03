import BasePage from './basePage';

export default class HomePage extends BasePage {
  constructor(driver, asserters) {
    super(driver);
    this.asserters = asserters;
  }

  waitForHomePageToLoad() {
    return this.switchToWebViewDriver()
               .waitForElementByCssSelector('.ion-log-out',
                  this.asserters.isDisplayed, 20000, 1000);
  }

  clickAddCandidate() {
    return this.switchToWebViewDriver().elementByCssSelector('button.ion-plus-round').click();
  }

  clickSignUp() {
    return this.switchToWebViewDriver().elementByCssSelector(
      'button[ng-click=\'signingUp($event, item)\']:not(.button-pseudo-disabled)').click();
  }

  async clickConfirm() {
    const buttons = await this.switchToWebViewDriver().
    waitForElementsByCssSelector('.button.ng-binding.button-positive');
    return buttons[1].click();
  }

  getConfirmationMessage() {
    return this.switchToWebViewDriver().
    waitForElementByCssSelector('.popup-body',
                  this.asserters.isDisplayed, 20000, 1000).text();
  }

  clickMyInterviewsTabs() {
    return this.switchToWebViewDriver().elementByLinkText('My Interviews').click();
  }

  clickFeedbackButton() {
    return this.switchToWebViewDriver().waitForElementByCssSelector(
      '.button[ng-click=\'$event.stopPropagation()\']',
      this.asserters.isDisplayed, 20000, 1000).click();
  }
}

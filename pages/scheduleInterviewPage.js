import BasePage from './basePage';

export default class ScheduleInterviewPage extends BasePage {
  constructor(driver, asserters) {
    super(driver);
    this.asserters = asserters;
  }

  waitToLoad() {
    return this.switchToWebViewDriver()
               .waitForElementByCss('ion-view div div button[ng-click=\'postCandidate()\']', this.asserters.isDisplayed, 10000, 1000);
  }
}

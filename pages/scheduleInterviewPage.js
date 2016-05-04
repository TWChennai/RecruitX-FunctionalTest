import BasePage from './basePage';

export default class ScheduleInterviewPage extends BasePage {
  constructor(driver, asserters) {
    super(driver);
    this.asserters = asserters;
  }

  waitToLoad() {
    return this.switchToWebViewDriver()
            .waitForElementByCss(
              'ion-view div div button[ng-click=\'postCandidate()\']',
              this.asserters.isDisplayed, 20000, 1000);
  }

  save() {
    return this.switchToWebViewDriver().elementByCss(
      'div.row div button[ng-click=\'postCandidate()\']').click();
  }

  getInterviewRounds() {
    return this.switchToWebViewDriver().waitForElementsByCss(
      'ion-content ion-list div ion-item div', this.asserters.isDisplayed, 10000, 1000);
  }

  resolveTextContent(elements) {
    const textPromises = [];
    for (let i = 0; i < elements.length; i++) {
      textPromises.push(elements[i].text());
    }
    return Promise.all(textPromises);
  }

  async scheduleInterviews(schedules) {
    const elements = await this.getInterviewRounds();
    const contents = await this.resolveTextContent(elements);
    for (let i = 0; i < schedules.length; i++) {
      const { InterviewRound: interviewRound, IntervalInDays: intervalInDays, amPm: amPm,
        Hours: hours, Minutes: minutes } = schedules[i];

      const index = contents.findIndex(content => content === interviewRound);
      if (index !== -1) {
        await this.scheduleInterview(elements[index], intervalInDays, amPm, hours, minutes);
      }
    }
  }

  scheduleInterview(element, intervalInDays, amPm, hours, minutes) {
    const that = this;
    function clickOk() {
      return that.switchToNativeAppDriver().elementById('android:id/button1').click();
    }

    function enterDate() {
      const driver = that.switchToNativeAppDriver();
      const interviewDate = new Date();
      interviewDate.setDate(interviewDate.getDate() + parseInt(intervalInDays, 10));
      const locale = 'en-us';
      const month = interviewDate.toLocaleString(locale, { month: 'short' });
      return driver.elementById('android:id/month').setText(month)
      .then(() => {
        driver.elementById('android:id/day').type(interviewDate.getDate());
      })
      // .then(() => {
      //   driver
      //   .elementById('android:id/year').type(interviewDate.getFullYear());
      // })
      .then(clickOk);
    }

    function enterTime() {
      const driver = that.switchToNativeAppDriver();
      const promises = [driver.elementById('android:id/hour').type(hours),
      driver.elementById('android:id/minute').setText(minutes)];
      return Promise.all(promises)
      .then(() => {
        driver.elementById('android:id/amPm').text();
      })
      .then(text => {
        if (text !== amPm) {
          return driver.elementById('android:id/amPm').click();
        }
        return Promise.resolve(text);
      })
      .then(clickOk);
    }

    return this.switchToWebViewDriver()
    .then(() => element)
    .click()
    .then(enterDate)
    .then(enterTime);
  }
}

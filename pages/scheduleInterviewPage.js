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

  getInterviewRounds() {
    return this.switchToWebViewDriver().elementsByCss('ion-content ion-list div ion-item div');
  }

  resolveTextContent(elements) {
    var text_promises = [];
    for(var i = 0;i < elements.length;i++) {
      text_promises.push(elements[i].text());
    }
    return Promise.all(text_promises);
  }

  scheduleInterview(element){
    var driver = this.switchToNativeAppDriver();

    function clickOk(){
      return driver.elementById('android:id/button1').click();
    }

    function enterDate() {
      var promises = [driver.elementById('android:id/month').type('May'),
      driver.elementById('android:id/day').type('30')];
      return Promise.all(promises)
      .then(function(){
        return driver.elementById('android:id/year').type('2017');
      })
      .then(clickOk);
    }

    function enterTime(){
      var promises = [driver.elementById('android:id/amPm').click(),
      driver.elementById('android:id/hour').type('12'),
      driver.elementById('android:id/minute').setText('12')];
      return Promise.all(promises)
      .then(clickOk);
    }

    return element
    .click()
    .then(enterDate)
    .then(enterTime);
  }
}

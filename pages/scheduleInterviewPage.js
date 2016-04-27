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

  scheduleInterview(element, intervalInDays, amPm, hours, minutes){
    var driver = this.switchToNativeAppDriver();
    function clickOk(){
      return driver.elementById('android:id/button1').click();
    }

    function enterDate() {
      var interviewDate = new Date();
      interviewDate.setDate(interviewDate.getDate() + parseInt(intervalInDays));
      var locale = "en-us";
      var month = interviewDate.toLocaleString(locale, { month: "short" });
      return driver.elementById('android:id/month').setText(month)
      .then(function(){
        return driver.elementById('android:id/day').type(interviewDate.getDate());
      })
      .then(function(){
        return driver.elementById('android:id/year').type(interviewDate.getFullYear());
      })
      .then(clickOk);
    }

    function enterTime(){
      var promises = [driver.elementById('android:id/hour').type(hours),
      driver.elementById('android:id/minute').setText(minutes)];
      return Promise.all(promises)
      .then(function(){
        return driver.elementById('android:id/amPm').text();
      })
      .then(function(text){
        if (text !== amPm) {
          return driver.elementById('android:id/amPm').click();
        }
      })
      .then(clickOk);
    }

    return element
    .click()
    .then(enterDate)
    .then(enterTime);
  }
}

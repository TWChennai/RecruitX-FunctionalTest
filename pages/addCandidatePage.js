import BasePage from './basePage';

export default class AddCandidatePage extends BasePage {
  constructor(driver, asserters) {
    super(driver);
    this.asserters = asserters;
  }

  waitForAddCandidatePageToLoad() {
    return this.switchToWebViewDriver()
               .waitForElementByCss('div.title', this.asserters.isDisplayed, 10000, 1000);
  }

  enterFirstName(firstName) {
    return this.switchToWebViewDriver().elementByName('firstName', 60000, 10000).type(firstName);
  }

  enterLastName(lastName) {
    return this.switchToWebViewDriver().elementByName('lastName', 60000, 10000).type(lastName);
  }

  selectRole(role) {
    return this.switchToWebViewDriver().elementByCss(`option[label=\'${role}\']`,
     60000, 10000).click();
  }

  enterExperience(experience) {
    return this.switchToWebViewDriver().elementByName('experience').type(experience);
  }

  selectSkills(skills) {
    const promise = new Promise((resolve, reject) => {
      this.switchToWebViewDriver().elementsByCss('ion-list div.list > label')
        .then(elements => {
          let textResolvedCounter = 0;
          const clickPromises = [];
          return new Promise(textResolve => {
            for (let i = 0; i < elements.length; i++) {
              const element = elements[i];
              element.text().then(content => {
                textResolvedCounter++;
                if (skills.find(skill => skill === content)) {
                  clickPromises.push(element.click());
                }
                if (textResolvedCounter === elements.length) {
                  textResolve(clickPromises);
                }
              });
            }
          })
          .then(clickPromisesReturned => {
            Promise.all(clickPromisesReturned).then(value => {
              resolve(value);
            }, reason => {
              reject(reason);
            });
          });
        });
    });
    return promise;
  }

  clickNext() {
    return this.switchToWebViewDriver().elementByCss(
      'form div a[ng-click=\'processCandidateData()\']', 60000, 10000).click();
  }
}

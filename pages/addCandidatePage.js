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

  getTitle() {
    return this.switchToWebViewDriver().elementByCss('div[nav-bar=\'active\'] .title').text();
  }

  enterFirstName(firstName) {
    return this.switchToWebViewDriver().elementByName('firstName', 60000, 10000).type(firstName);
  }

  enterLastName(lastName) {
    return this.switchToWebViewDriver().elementByName('lastName', 60000, 10000).type(lastName);
  }

  selectRole(role) {
    return this.switchToWebViewDriver().elementByCss('option[label=\'' + role + '\']', 60000, 10000).click();
  }

  enterExperience(experience) {
    return this.switchToWebViewDriver().elementByName('experience').type(experience);
  }

  selectSkills(skills) {
    var that = this;
    var textYPromise;
    var promise = new Promise(function(resolve, reject){
      that.switchToWebViewDriver().elementsByCss('ion-list div.list > label')
        .then(function(elements){
          var text_resolved_counter = 0;
          var click_promises = [];
          return new Promise(function(text_resolve){
            for(var i = 0; i < elements.length; i++){
              let element = elements[i];
              element.text().then(function(content){
                text_resolved_counter++;
                if(skills.find(skill => skill === content)){
                  click_promises.push(element.click());
                }
                if(text_resolved_counter == elements.length){
                  text_resolve(click_promises);
                }
              });
            }
          })
          .then(function(click_promises_returned){
            Promise.all(click_promises_returned).then(function(value){
              resolve(value);
            }, function(reason){
              reject(reason);});
          });
          });
    });
    return promise;
  }

  clickNext() {
    return this.switchToWebViewDriver().elementByCss('form div a[ng-click=\'processCandidateData()\']', 60000, 10000).click();
  }
}

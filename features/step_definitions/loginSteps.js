export default function () {
  this.Given(/^I open the recruitx app and land on login page$/, function (done) {
    const that = this;
    this.LoginPage.waitForLoginPageToLoad().then(function(){
      that.LoginPage.title().should.eventually.eql('RecruitX').notify(done);
    });
  });
}

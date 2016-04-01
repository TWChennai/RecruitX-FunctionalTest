import steps from 'artstep';

export default steps()

  .Given(/^I open the recruitx app and land on login page$/, async function() {
    await this.LoginPage.waitForLoginPageToLoad();
    const title = await this.LoginPage.title();
    title.should.equal('RecruitX');
  })

  .When(/^I signin as a developer$/, async function() {
    await this.LoginPage.enterUsername('ppanelist');
    await this.LoginPage.enterPassword('P@ssw0rd');
    await this.LoginPage.clickSignIn();
  })

  .When(/^I provide my experience$/, async function() {
    await this.LoginPage.enterExperience('2');
    await this.LoginPage.clickDoneOnExperience();
  })

  .Then(/^I should be on home page$/, async function() {
    await this.HomePage.waitForHomePageToLoad();
    const title = await this.HomePage.title();
    title.should.equal('Hi panelist!');
  });

import steps from 'artstep';

export default steps()

  .Given('I open the recruitx app and land on login page', async function() {
    const title = await this.LoginPage.title();
    title.should.equal('RecruitX');
  })

  .When('I signin with credentials $username and $password', async function(username, password) {
    await this.LoginPage.enterUsername(username);
    await this.LoginPage.enterPassword(password);
    await this.LoginPage.clickSignIn();
  })

  .When('I provide my experience as $years', async function(years) {
    await this.LoginPage.enterExperience(years);
    await this.LoginPage.clickDoneOnExperience();
  })

  .Then('I should be on home page with title $expectedTitle', async function(expectedTitle) {
    await this.HomePage.waitForHomePageToLoad();
    const actualTitle = await this.HomePage.title();
    actualTitle.should.equal(expectedTitle);
  })

  .Then('I should be on login page with an error message as $expectedErrorMessage',
    async function(expectedErrorMessage) {
      const actualErrorMessage = await this.LoginPage.getErrorMessage();
      actualErrorMessage.should.equal(expectedErrorMessage);
    });

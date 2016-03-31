import cucumberAsync from '../support/utils.js';
import steps from 'artstep'

export default steps()
  .Given(/^I open the recruitx app and land on login page$/, async function() {
    await this.LoginPage.waitForLoginPageToLoad();
    const title = await this.LoginPage.title();
    title.should.equal('RecruitX');
  });

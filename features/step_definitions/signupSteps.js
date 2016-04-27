import steps from 'artstep';

export default steps()

.Then('I should be able to signup', async function() {
  await this.HomePage.clickSignUp();
});

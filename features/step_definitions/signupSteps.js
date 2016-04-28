import steps from 'artstep';

export default steps()

.Then('I should be able to signup', async function() {
  await this.HomePage.clickSignUp();
  await this.HomePage.clickConfirm();
  const expectedMessage = 'Thanks for signing up for this interview!';
  const actualMessage = await this.HomePage.getConfirmationMessage();
  actualMessage.should.equal(expectedMessage);
});

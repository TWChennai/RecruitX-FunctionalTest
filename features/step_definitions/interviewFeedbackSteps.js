import steps from 'artstep';

export default steps()

  .When('I open my interviews tab', async function() {
    await this.HomePage.waitForHomePageToLoad();
    await this.HomePage.clickMyInterviewsTabs();
  })

  .When('I enter feedback', async function() {
    await this.InterviewFeedbackPage.clickPursueLink();
  })

  .When('I capture feedback image in camera', async function() {
    await this.InterviewFeedbackPage.clickCameraIcon();
    const elements = await this.InterviewFeedbackPage.captureCameraImage();
  })

  .When('I click on Feedback button', async function() {
    await this.HomePage.clickFeedbackButton();
  })

  .When('I click on Submit feedback button', async function() {
    await this.InterviewFeedbackPage.clickSubmitButton();
  })

  .When('I confirm submission', async function() {
    await this.InterviewFeedbackPage.clickConfirm();
  })

  .Then('I should get confirmation message', async function() {
    const expectedMessage = 'Feedback submitted';
    const actualMessage = await this.InterviewFeedbackPage.getConfirmationMessage();
    actualMessage.should.equal(expectedMessage);
  });

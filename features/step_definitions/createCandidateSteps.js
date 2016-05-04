import steps from 'artstep';

export default steps()

  .When(/^I touch the add candidate icon$/, async function() {
    await this.HomePage.clickAddCandidate();
  })

  .When(/^I schedule the following rounds$/, async function(table) {
    await this.ScheduleInterviewPage.scheduleInterviews(table.hashes());
  })

  .When(/^I enter the following candidate details$/, async function(table) {
    const [{ FirstName: firstName, LastName: lastName, Role: role,
      Experience: experience, Skills: skills }] = table.hashes();
    await this.AddCandidatePage.enterFirstName(firstName);
    await this.AddCandidatePage.enterLastName(lastName);
    await this.AddCandidatePage.selectRole(role);
    await this.AddCandidatePage.enterExperience(experience);
    await this.AddCandidatePage.selectSkills(skills.split(', '));
  })

  .When(/^I click the next button$/, async function() {
    await this.AddCandidatePage.clickNext();
  })

  .When('I save the schedule', async function() {
    await this.ScheduleInterviewPage.save();
  })

  .When('I click ok', async function() {
    await this.ScheduleInterviewPage.clickOk();
  })

  .Then('I should be on Add Candidate page', async function() {
    await this.AddCandidatePage.waitForAddCandidatePageToLoad();
    const actualTitle = await this.AddCandidatePage.getTitle();
    actualTitle.should.equal('Add Candidate');
  })

  .Then('I should be on Schedule Interview page', async function() {
    await this.ScheduleInterviewPage.waitToLoad();
    const actualTitle = await this.ScheduleInterviewPage.getTitle();
    actualTitle.should.equal('Schedule Interview');
  })

  .Then('I should see a success message', async function() {
    const actualTitle = await this.ScheduleInterviewPage.getConfirmationMessage();
    actualTitle.should.equal('Candidate Interview successfully added!!');
  })

  .Then('I should be on home page', async function() {
    await this.HomePage.waitForHomePageToLoad();
  });

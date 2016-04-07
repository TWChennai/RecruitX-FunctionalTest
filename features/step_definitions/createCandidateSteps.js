import steps from 'artstep';

export default steps()

  .When(/^I touch the add candidate icon$/, async function() {
    await this.HomePage.clickAddCandidate();
  })

  .When(/^I enter the following candidate details$/, async function(table) {
    var [{FirstName: firstName, LastName: lastName, Role: role, Experience: experience, Skills: skills}] = table.hashes();
    await this.AddCandidatePage.enterFirstName(firstName);
    await this.AddCandidatePage.enterLastName(lastName);
    await this.AddCandidatePage.selectRole(role);
    await this.AddCandidatePage.enterExperience(experience);
    await this.AddCandidatePage.selectSkills(skills.split(', '))
  })

  .When(/^I click the next button$/, async function() {
    await this.AddCandidatePage.clickNext();
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
  });

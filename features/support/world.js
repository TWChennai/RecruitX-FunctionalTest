import wd from 'wd';
import chai from 'chai';
import chaiAsPromised from 'chai-as-promised';
import LoginPage from '../../pages/loginPage.js';
import HomePage from '../../pages/homePage.js';
import AddCandidatePage from '../../pages/addCandidatePage.js';
import ScheduleInterviewPage from '../../pages/scheduleInterviewPage.js';
import InterviewFeedbackPage from '../../pages/interviewFeedbackPage.js';
import steps from 'artstep';

export default function () {
  chai.should();
  chai.use(chaiAsPromised);
  chaiAsPromised.transferPromiseness = wd.transferPromiseness;

  this.World = function () {
    this.driver = wd.promiseChainRemote({ host: 'localhost', port: 4723 });
    this.asserters = wd.asserters;
    this.steps = steps();
    this.LoginPage = new LoginPage(this.driver, this.asserters);
    this.HomePage = new HomePage(this.driver, this.asserters);
    this.AddCandidatePage = new AddCandidatePage(this.driver, this.asserters);
    this.ScheduleInterviewPage = new ScheduleInterviewPage(this.driver, this.asserters);
    this.InterviewFeedbackPage = new InterviewFeedbackPage(this.driver, this.asserters);
  };
}

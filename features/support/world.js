import wd from 'wd';
import chai from 'chai';
import chaiAsPromised from 'chai-as-promised';
import LoginPage from '../../pages/loginPage.js';
import HomePage from '../../pages/homePage.js';
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
  };
}

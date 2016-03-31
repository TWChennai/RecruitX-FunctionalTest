import wd from 'wd';
import chai from 'chai';
import chaiAsPromised from 'chai-as-promised';
import LoginPage from '../../pages/loginPage.js';
import steps from 'artstep';

export default function () {
  chai.should();
  chai.use(chaiAsPromised);
  chaiAsPromised.transferPromiseness = wd.transferPromiseness;

  this.World = function () {
    this.driver = wd.promiseChainRemote({ host: 'localhost', port: 4723 });
    this.steps = steps();
    this.LoginPage = new LoginPage(this.driver);
  };
}

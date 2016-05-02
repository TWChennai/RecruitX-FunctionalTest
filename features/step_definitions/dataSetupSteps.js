import steps from 'artstep';
import DataSetup from '../../utils/db/dataSetup.js';

export default steps()
  .Given('the recruiter has scheduled a $QA interview', async function(role) {
    const response = await DataSetup.createCandidate(role);
    response.status.should.equal(201);
  })
  .Given('the ppanelist has signed up for interview', async function() {
    const response = await DataSetup.signupInterview('Dev', 'ppanelist');
    response.status.should.equal(201);
  });

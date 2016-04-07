import steps from 'artstep';
import DataSetup from '../../utils/db/dataSetup.js';

export default steps()
  .Given('the recruiter has scheduled a $QA interview', async function(role) {
    const response = await DataSetup.createCandidate(role);
    response.status.should.equal(201);
  });

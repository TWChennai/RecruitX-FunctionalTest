import config from '../../config.js';
import fetch from 'isomorphic-fetch';
import * as util from '../helper.js';

class DataSetup {
  constructor() {
    this.env = config[process.env.ENV];
  }

  getRoleId(role) {
    const roleIdMap = { DEV: 1, QA: 2 };
    return roleIdMap[role];
  }

  getHeaders() {
    return {
      'Content-Type': 'application/json',
      Authorization: this.env.Authorization,
    };
  }

  async createCandidate(role) {
    const jsonBody = JSON.stringify({
      candidate: {
        first_name: role,
        last_name: 'Candidate',
        experience: 10,
        skill_ids: [2, 3],
        role_id: this.getRoleId(role),
        interview_rounds: [{
          start_time: util.getFormattedCurrentDateTime(),
          interview_type_id: 1,
        }],
        pipeline_status_id: 1,
      },
    });

    const requestOptions = {
      method: 'POST',
      headers: this.getHeaders(),
      body: jsonBody,
    };

    const createCandidateURI = `${this.env.uri}/candidates`;
    const response = await fetch(createCandidateURI, requestOptions);
    return response;
  }
}
export default new DataSetup();

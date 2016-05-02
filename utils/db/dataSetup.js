import config from '../../config.js';
import fetch from 'isomorphic-fetch';
import * as util from '../helper.js';

class DataSetup {
  constructor() {
    this.env = config[process.env.ENV];
  }

  getRoleId(role) {
    const roleIdMap = { DEV: 1, QA: 2, Dev: 1 };
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
        experience: 1,
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

  async getInterviews(role, panelist) {
    const requestOptions = {
      method: 'GET',
      headers: this.getHeaders()
    };

    const signupInterviewURI = `${this.env.uri}/interviews?panelist_experience=10&panelist_login_name=${panelist}&panelist_role=${role}`;
    const response = await fetch(signupInterviewURI, requestOptions);
    const json = await response.json();
    var filtered = json.filter(allowsSignupAndIsInPast);
    return filtered[0].id;
  }

  async signupInterview(role, panelist) {
    await this.createCandidate(role);
    var interview_id = await this.getInterviews(role, panelist);
    const jsonBody = JSON.stringify({
      'interview_panelist': {
        'panelist_login_name': panelist,
        'interview_id': interview_id,
        'panelist_role': role,
        'panelist_experience': 10
      }
    });

    const requestOptions = {
      method: 'POST',
      headers: this.getHeaders(),
      body: jsonBody,
    };

    const signupInterviewURI = `${this.env.uri}/panelists`;
    const response = await fetch(signupInterviewURI, requestOptions);
    return response;

  }
}

export function allowsSignupAndIsInPast(interview) {
  return interview.signup_error === '';
}

export default new DataSetup();

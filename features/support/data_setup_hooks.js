export default function () {
  this.Before('@clearInterviewPanelists', () => {
    const pg = require('pg');
    const connectionString = process.env.DB_CONNECTION_STRING;
    pg.defaults.poolIdleTimeout = 600000;

    pg.connect(connectionString, (err, client) => {
      if (err) throw err;

      client
      .query('DELETE from interview_panelists;');
      client
      .query('DELETE from interviews;');
      client
      .query('DELETE from candidates;');
    });
  });
}

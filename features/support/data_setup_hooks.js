var dataSetupHooks = function () {
  this.Before('@clearInterviewPanelists', function (scenario) {
    var pg = require('pg');
    var connectionString = process.env.DB_CONNECTION_STRING;
    pg.defaults.poolIdleTimeout = 600000;

    pg.connect(connectionString, function (err, client) {
      if (err) throw err;

      client
      .query('DELETE from interview_panelists;');
      client
      .query('DELETE from interviews;');
      client
      .query('DELETE from candidates;');
    });
  });
};

module.exports = dataSetupHooks;

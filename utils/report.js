import Report from 'cucumber-html-report';

const reportsDir = `${__dirname}/../reports`;

const options = {
  source: `${reportsDir}/cucumber_report.json`,
  dest: `${reportsDir}`,
  name: 'report.html',
};

const report = new Report(options);
report.createReport();

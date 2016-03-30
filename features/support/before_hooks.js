import capabilities from './caps.js';

export default function () {
  this.Before(function (scenario, done) {
    const desiredCapabilities = capabilities[process.env.PLATFORM][process.env.VERSION];
    this.driver.init(desiredCapabilities).nodeify(done);
  });
}

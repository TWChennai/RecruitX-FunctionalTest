export default function () {
  this.After(function (scenario, done) {
    this.driver.quit().nodeify(done);
  });
}

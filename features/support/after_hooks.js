import steps from 'artstep';

export default steps()
  .after(async function (scenario) {
    if (scenario.isFailed()) {
      const buffer = await this.driver.context('NATIVE_APP').takeScreenshot();
      await scenario.attach(new Buffer(buffer, 'base64').toString('binary'), 'image/png');
    }
    await this.driver.quit();
  });

import steps from 'artstep';
import fs from 'fs';

export default steps()
  .after(async function (scenario) {
    if (scenario.isFailed()) {
      const buffer = await this.driver.context('NATIVE_APP').takeScreenshot();
      const filePath = `${__dirname}/../../reports/screenshots/${scenario.getName()}.png`;
      await fs.writeFile(filePath, buffer, 'base64');
    }
    await this.driver.quit();
  });

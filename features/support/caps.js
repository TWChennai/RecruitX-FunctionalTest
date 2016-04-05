export default {
  android: {
    4.4: {
      platformName: 'Android',
      platformVersion: '4.4',
      deviceName: 'Android Emulator',
      app: `${__dirname}/../../apps/android-debug.apk`,
    },
    5.1: {
      platformName: 'Android',
      platformVersion: '5.1',
      deviceName: 'Android Phone',
      app: `${__dirname}/../../apps/android-debug.apk`,
    },
  },
};

# Functional Tests

RecruitX hybrid app functional tests Framework.

###Setup Automation Framework
- Install node v5.9.1
- Install Appium 1.3.7 GUI server https://github.com/appium/appium-dot-app
- `npm Install`

###Atom packages
- Editorconfig
- language-gherkin
- linter-eslint
- language-babel

###Steps to run Android tests
- Open Appium GUI and Launch server (make sure Appium Doctor runs fine before launching)
- Setup Emulator with Android 4.4 and launch
- `VERSION='4.4' ENV='QA' npm run android`
- `npm run test-with-report` will generate html report under reports folder.

###Help Links
- https://github.com/appium/appium/blob/master/docs/en/advanced-concepts/hybrid.md
- http://appium.io/slate/en/tutorial/android.html?ruby#getting-started-with-appium
- https://github.com/admc/wd/blob/master/doc/api.md
- https://github.com/cucumber/cucumber-js
- https://github.com/dtinth/artstep
- https://github.com/airbnb/javascript
- https://github.com/gayathrim/FunctionalTests/tree/master/Mobile/NativeAppium

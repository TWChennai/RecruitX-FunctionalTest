Feature: As a TWer, I want to use my okta credentials to login Recruitx app

Scenario: Verify TWer is able to successfully login.
Given I open the recruitx app and land on login page
When I signin as a developer with credentials ppanelist and P@ssw0rd
When I provide my experience as 2
Then I should be on home page with title Hi panelist!

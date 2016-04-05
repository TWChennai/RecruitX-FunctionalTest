Feature: As a TWer, I want to use my okta credentials to login Recruitx app

Scenario: Verify TWer is able to successfully login as a developer.
Given I open the recruitx app and land on login page
When I signin with credentials ppanelist and P@ssw0rd
When I provide my experience as 2
Then I should be on home page with title Hi panelist!

Scenario: Verify TWer is able to successfully login as a QA.
Given I open the recruitx app and land on login page
When I signin with credentials ppanelistp and P@ssw0rd
When I provide my experience as 2
Then I should be on home page with title Hi panelistnew!

Scenario: Verify TWer is able to successfully login as a recruiter.
Given I open the recruitx app and land on login page
When I signin with credentials rrecruitx and P@ssw0rd
Then I should be on home page with title Hi recruiter!

Scenario: Verify invalid credentials throw error message.
Given I open the recruitx app and land on login page
When I signin with credentials ppanelist and password
Then I should be on login page with an error message as Authentication

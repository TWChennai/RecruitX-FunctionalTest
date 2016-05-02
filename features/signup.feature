Feature: As a TWer I should be able to view the list of interviews and signup for a convenient time.

@clearInterviewPanelists
Scenario: Verify a QA is able to sign up for a QA interview
Given the recruiter has scheduled a QA interview
Given I open the recruitx app and land on login page
When I signin with credentials ppanelistp and P@ssw0rd
When I provide my experience as 25
Then I should be on home page with title Hi panelistnew!
Then I should be able to signup

@wip
Scenario: Verify a Dev is able to sign up for a Dev interview
Given the recruiter has scheduled a DEV interview

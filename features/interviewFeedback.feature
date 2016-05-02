Feature: As a TWer I should be able to enter feedback for the interview i have signed up for.

@clearInterviewPanelists
Scenario: Verify a TWer is able to enter feedback for his interview
Given the ppanelist has signed up for interview
Given I open the recruitx app and land on login page
When I signin with credentials ppanelist and P@ssw0rd
When I provide my experience as 10
When I open my interviews tab
When I click on Feedback button
When I enter feedback
When I capture feedback image in camera
When I click on Submit feedback button
When I confirm submission
Then I should get confirmation message

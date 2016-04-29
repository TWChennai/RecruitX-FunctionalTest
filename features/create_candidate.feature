Feature: As a recruiter, I want to create candidates so that panelists can sign up

Scenario: Verify recruiter is able to successfully create a dev candidate
  Given I open the recruitx app and land on login page
  When I signin with credentials rrecruitx and P@ssw0rd
  Then I should be on home page with title Hi recruiter!
  When I touch the add candidate icon
  Then I should be on Add Candidate page
  When I enter the following candidate details
    | FirstName | LastName  | Role  | Experience  | Skills          |
    | Candidate | One       | Dev   | 2.00        | Java            |
  When I click the next button
  Then I should be on Schedule Interview page
  When I schedule the following rounds
    | InterviewRound | IntervalInDays | Hours | Minutes | amPm |
    | Coding         | 12             | 07    | 00      | AM   |

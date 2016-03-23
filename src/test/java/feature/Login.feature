Feature: Login details

  Scenario: Verify valid login
    When I provide username as ppanelist
    And I provide password as P@ssw0rd
    And I submit login
  When I provide 1 as experience
  When I submit experience
  Then I should see <> as home page title
#    Then I should see title as Hi panelist

Feature: Login details

  Scenario: Verify valid login
    When I provide username as ppanalist
    When I provide password as P@ssw0rd
    When I submit login
    Then I should see title as Hi panelist

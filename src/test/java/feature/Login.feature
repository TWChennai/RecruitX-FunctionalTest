Feature: Login details

  Scenario: Verify valid login
    When I provide username as abcd
    When I provide password as 1234
    When I submit login
#    When I provide credential as <abcd>
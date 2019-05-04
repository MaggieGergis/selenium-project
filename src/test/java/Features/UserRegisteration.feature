Feature: User Registeration
  I want to check the user can register at Nop-Commerce website.

  Scenario: User can register successfully   

    Given User is on HomePage.
    When Click on Register Link.
    And User enter Valid Data.
    Then User Registeration Page should be dispayed Successfully

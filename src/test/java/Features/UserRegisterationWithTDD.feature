Feature: User Registeration With TDD
  I want to check the user can register at Nop-Commerce website.

  Scenario Outline: User can register successfully wth TDD
    Given User is on HomePage With TDD.
    When Click on Register Link With TDD.
    And User enter Valid Data "<FirstName>" , "<LastName>" , "<Email>", "<Company>" , "<Password>" 
    Then User Registeration Page should be dispayed Successfully With TDD.

    Examples: 
     | FirstName  | LastName | Email  | Company | Password |
     |Da | Em | Da.Em@gmail.com | IT | Da2165 |
     |Jo | Em | Jo.Em@gmail.com | IT | Jo12634|

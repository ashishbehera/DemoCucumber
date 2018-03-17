Feature: LoginFeature
  This feature deals with login functionality of the application

  Scenario: Login with correct username and password
    Given I navigate to the login page
    And  I enter the user email address as Email:admin
    And  I verify the count of my salary digits for Rs 1000
    And I enter the following for login
      | username | password      |
      | admin    | adminpassword |
    And I click login button
    Then I should see the userform page

  Scenario Outline: Login with correct username and password with scenario outline
    Given I navigate to the login page
    And I enter the <username> and <password>
    And I click login button
    Then I should see the userform page

    Examples:

      | username | password      |
      | admin    | adminpassword |
      | test     | test          |
      
      
      Test Merge Issue



Feature: Login
  As user
  I want to login and see success message


  Scenario: Login with valid credentials
    Given Open homepage
    When Fill and send valid login form
    Then See success message


  Scenario Outline: Login with invalid credentials
    Given Open homepage
    When Fill and send invalid login form <email> <password>
    Then See error message
    Examples:
      | email       | password   |
      | aaaa@aaa.aa | aaaaaaaaaa |
      | aaaaaaaa.aa | aaaaaaaaaa |
      | aaaa@aaaaaa | aaaaaaaaaa |
      | aaaaaaaaaaa | aaaaaaaaaa |
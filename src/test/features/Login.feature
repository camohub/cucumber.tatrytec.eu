
@user
Feature: Login success + errors
  As user I want to login and see success or error message


  Scenario Outline: Login with invalid credentials
    Given Open homepage
    When Open login modal
    And Fill and send invalid login form <email> <password>
    Then Check error "Nesprávny email, alebo heslo."
    Examples:
      | email       | password   |
      | aaaa@aaa.aa | aaaaaaaaaa |
      | aaaaaaaa.aa | aaaaaaaaaa |
      | aaaa@aaaaaa | aaaaaaaaaa |
      | aaaaaaaaaaa | aaaaaaaaaa |


  @last
  Scenario: Login with valid credentials
    Given Open homepage
    When Open login modal
    When Fill and send valid login form
    Then Check success "Vitajte na palube"
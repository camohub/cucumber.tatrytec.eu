
@maximize @social-networks
Feature: Login via social networks - Github, Google, Facebook
  As user I want to login and see success or error message


  Scenario: Login with Github
    Given Open homepage
    When Open article detail
    And Click on Github login button
    And Fill Github login form
    Then Check success


  Scenario: Login with Facebook
    Given Open homepage
    When Open article detail
    And Click on Facebook login button
    And Fill Github login form
    Then Check error "Používateľ so zadaným emailom je už zaregistrovaný cez github"


#  Scenario: Login with Google
#    Given Open homepage
#    When Open article detail
#    And Click on Google login button
#    And Fill Google login form
#    Then Check success
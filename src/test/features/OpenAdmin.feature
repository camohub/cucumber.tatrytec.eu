
@admin
Feature: Admin login
  As user
  I want to login
  To have access to admin


  Scenario: Login in with valid credentials and open Admin page
    Given Login with valid credentials
    When Click on admin link
    Then Check admin page
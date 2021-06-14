
@comments
Feature: Homepage elements
  Check comments functionality


  Scenario: Check article comments
    Given User is logged in
    And Open article detail
    And Write a comment "Selenium test"
    Then Save comment
    And Check the comment exists "Selenium test"


  @last
  Scenario: Check article comments delete
    Given User is logged in and is on admin page
    And Open articles admin page
    And Open article comments admin
    Then Delete comment "Selenium test"
    And Check success
    Then Check invisible status of comment "Selenium test"

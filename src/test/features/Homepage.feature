Feature: Test homepage elements
  Check all main elements on homepage


  Scenario: Check main elements on homepage
    When Simple open homepage
    And Check header
    And Check side menu
    And Check articles count
    And Check paginator

@admin @maximize @articles
Feature: Admin articles filter


  Scenario: Test filter by user name
    Given User is logged in and is on admin page
    When Click on edit articles link
    And Select Test User in user name filter
    And Send filter form
    Then Articles table should contain only Test User articles


  Scenario: Test filter by article title
    Given User is logged in and is on admin page
    When Click on edit articles link
    And Fill existing title in title input
    And Send filter form
    Then Articles table should contain only filtered title


  Scenario: Test filter by date ascending
    Given User is logged in and is on admin page
    When Click on edit articles link
    And Select order by date ascending
    And Send filter form
    Then Articles table should be sorted by date ascending


  @last
  Scenario: Test filter by date descending
    Given User is logged in and is on admin page
    When Click on edit articles link
    And Select order by date descending
    And Send filter form
    Then Articles table should be sorted by date descending


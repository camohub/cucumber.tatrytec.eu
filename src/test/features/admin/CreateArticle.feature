
@admin @articles
Feature: Create article
  Try to create new article


  Scenario: Try to create new article
    When Click on new article link
    And Fill meta description
    And Fill title
    And perex
    And Fill text
    And Fill categories
    And Send form
    Then Check success message



@admin @articles
Feature: Create article
  Try to create new article


  Scenario: Try to create new article
    When Click on new article link
    And Fill meta description
    And Fill title
    And Fill perex
    And Fill text
    And Fill categories
    And Send form
    Then Check success message
    And Check article exists


  Scenario: Try to create article with existing title
    When Click on new article link
    And Fill meta description
    And Fill title
    And Fill perex
    And Fill text
    And Fill categories
    And Send form
    Then Check error message related to title already exists


  Scenario: Try to edit article
    When Click on edit articles link
    Then Click on edit icon
    And Edit meta description
    And Edit title
    And Edit perex
    And Edit text
    And Edit categories
    And Send form
    Then Check success message
    And Check article has been updated


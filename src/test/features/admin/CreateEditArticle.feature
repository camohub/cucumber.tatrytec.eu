
@admin @articles
Feature: Create and edit article
  Try to create and edit article


  Scenario: Try to create new article
    Given User is logged in and is on admin page
    When Click on new article link
    And Fill meta description
    And Fill title
    And Fill perex
    And Fill text
    And Fill categories
    And Send form
    Then Check article success message
    And Check article exists
    Then Click on edit icon
    And Check created title
    And Check crated meta description
    And Check crated perex
    And Check crated text
    And Check created categories


  Scenario: Try to create article with existing title
    Given User is logged in and is on admin page
    When Click on new article link
    And Fill meta description
    And Fill title
    And Fill perex
    And Fill text
    And Fill categories
    And Send form
    Then Check error message related to title already exists


  @last
  Scenario: Try to edit article
    Given User is logged in and is on admin page
    When Click on edit articles link
    Then Click on edit icon
    And Edit meta description
    And Edit title
    And Edit perex
    And Edit text
    And Edit categories
    And Send form
    Then Check article success message
    And Check article has been updated


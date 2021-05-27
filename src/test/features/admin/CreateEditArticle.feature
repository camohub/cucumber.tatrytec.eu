
@admin @maximize @articles
Feature: Create and edit article
  Try to create and edit article


  Scenario: Try to create new article
    Given User is logged in and is on admin page
    When Click on new article link
    And Fill meta description "Selenium test"
    And Fill title "Selenium test"
    And Fill perex "Selenium test"
    And Fill text "Selenium test"
    And Fill categories
    And Send form
    Then Check success "Článok bol uložený"
    And Check article exists "Selenium test"
    Then Click on edit icon "Selenium test"
    And Check created title "Selenium test"
    And Check crated meta description "Selenium test"
    And Check crated perex "Selenium test"
    And Check crated text "Selenium test"
    And Check created categories


  Scenario: Try to edit article
    Given User is logged in and is on admin page
    When Click on edit articles link
    Then Click on edit icon "Selenium test"
    And Fill meta description "Selenium test 2"
    And Fill title "Selenium test 2"
    And Fill perex "Selenium test 2"
    And Fill text "Selenium test 2"
    And Edit categories
    And Send form
    Then Check success
    And Check article has been updated "Selenium test 2"


  @last
  Scenario: Try to create article with existing title
    Given User is logged in and is on admin page
    When Click on new article link
    And Fill meta description "Selenium test 2"
    And Fill title "Selenium test 2"
    And Fill perex "Selenium test 2"
    And Fill text "Selenium test 2"
    And Fill categories
    And Send form
    Then Check error "Článok s rovnakým názvom už existuje"


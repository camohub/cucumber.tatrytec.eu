
@admin @maximize @categories
Feature: Create and edit category
  Try to create/edit category


  Scenario: Try to create new category
    Given User is logged in and is on admin page
    When Click on edit categories link
    Then Click on create new category button
    And Fill category name "Selenium test"
    And Send category form
    Then Check success "Kategória bola uložená do databázy"
    And Check category exists "Selenium test"
    And Check category is not visible


  # This has to be before scenario which tests existing category error
  Scenario: Try to edit category
    Given User is logged in and is on admin page
    When Click on edit categories link
    Then Click on category "Selenium test" edit icon
    And Check expected category name "Selenium test"
    Then Fill category name "Selenium test 2"
    And Send category form
    Then Check success "Kategória bola uložená do databázy"
    Then Check category has been updated "Selenium test 2"


  # This has to be after edit category
  Scenario: Try to create category with existing name
    Given User is logged in and is on admin page
    When Click on edit categories link
    Then Click on create new category button
    And Fill category name "Selenium test 2"
    And Send category form
    Then Check error "Kategória s rovnakým názvom už existuje"


  Scenario: Create subcategory
    Given User is logged in and is on admin page
    When Click on edit categories link
    Then Click on create new category button
    And Fill category name "Selenium test subcategory"
    And Set parent category "Selenium test 2"
    And Send category form
    Then Click on category "Selenium test 2" list open icon
    Then Click on category "Selenium test subcategory" edit icon
    And Check category exists "Selenium test subcategory"
    And Check parent category "Selenium test 2"


  @last
  Scenario: Test drag and drop categories sorting
    Given User is logged in and is on admin page
    When Click on edit categories link
    Then Click on category "Selenium test 2" list open icon
    Then Drag subcategory out of parent "Selenium test 2" category
    Then Save new categories order
    Then Check success "Poradie položiek bolo upravené"
    And Check if subcategory "Selenium test subcategory" is above the parent "Selenium test 2" category
    Then Drag subcategory "Selenium test subcategory" back inside the parent "Selenium test 2" category
    Then Save new categories order
    Then Check success "Poradie položiek bolo upravené"
    And Check if category "Selenium test subcategory" is inside the category "Selenium test 2"










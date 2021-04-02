
@admin @categories
Feature: Create and edit category
  Try to create/edit category


  Scenario: Try to create new category
    When Click on edit categories link
    Then Click on create new category button
    And Fill category name
    And Send category form
    Then Check success message
    And Check category exists
    And Check category is not visible


  Scenario: Try to create category with existing name
    When Click on edit categories link
    Then Click on create new category button
    And Fill category name
    And Send category form
    Then Check error message related to category already exists


  Scenario: Try to edit category
    When Click on edit categories link
    Then Click on edit category icon
    And Check expected category name
    Then Edit category name
    And Send category form
    Then Check success message
    Then Check category has been updated


  Scenario: Create subcategory
    When Click on edit categories link
    Then Click on create new category button
    And Fill subcategory name
    And Set parent category
    And Send category form
    Then Click on list open icon
    Then Click on edit subcategory icon
    And Check category exists
    And Check parent category


  @last
  Scenario: Test drag and drop categories sorting
    When Click on edit categories link
    Then Click on list open icon
    Then Drag test subcategory out of parent category
    Then Save new categories order
    Then Check sort success message
    And Check if subcategory is above the parent category
    Then Drag test subcategory back inside the parent category
    Then Save new categories order
    Then Check sort success message
    And Check if test category is inside the category










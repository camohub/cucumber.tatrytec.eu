package steps.admin;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.admin.CreateEditCategoryPage;
import steps.BaseAdminSteps;

import static java.lang.Thread.sleep;


public class CreateEditCategoriesSteps extends BaseAdminSteps
{

    CreateEditCategoryPage createEditCategoryPage;

    public String categoryName = "Selenium test";

    public String updatedCategoryName = "Selenium test update";

    public String subCategoryName = "Selenium test subcategory";



    // Constructor
    public CreateEditCategoriesSteps()
    {
        createEditCategoryPage = new CreateEditCategoryPage();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /// LINKS ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    @When("Click on edit categories link")
    public void clickOnEditCategoriesLink()
    {
       createEditCategoryPage.openEditCategoriesPage();
    }

    @Then("Click on create new category button")
    public void clickOnCreateNewCategoryButton()
    {
        createEditCategoryPage.openCreateCategoryForm();
    }

    @Then("Click on edit category icon")
    public void clickOnEditCategoryIcon()
    {
        createEditCategoryPage.clickOnEditCategoryIcon(categoryName);
    }

    @Then("Click on edit subcategory icon")
    public void clickOnEditSubCategoryIcon()
    {
        createEditCategoryPage.clickOnEditCategoryIcon(subCategoryName);
    }

    @Then("Click on list open icon")
    public void clickOnListOpenIcon()
    {
        createEditCategoryPage.clickOnListOpenIcon(updatedCategoryName);
    }

    /**
     * Current state is subCategory inside the parentCategory
     * Expected state is subCategory is outside and above the parentCategory
     */
    @Then("Drag test subcategory out of parent category")
    public void dragSubcategoryOutOfParentCategory()
    {
        String parentCategoryText = updatedCategoryName;
        createEditCategoryPage.dragSubcategoryOutOfParentCategory(parentCategoryText);
    }

    /**
     * Current state is subCategory is outside and above the parentCategory
     * Expected state is subCategory is back inside the parentCategory
     */
    @Then("Drag test subcategory back inside the parent category")
    public void dragSubCategoryBackToTheParentCategory()
    {
        String parentCategoryText = updatedCategoryName;
        String subCategoryText = subCategoryName;
        createEditCategoryPage.dragSubCategoryInsideTheParentCategory(parentCategoryText, subCategoryText);
    }

    @Then("Save new categories order")
    public void saveNewCategoriesOrder() throws InterruptedException
    {
        sleep(1500);  // Waiting for animations end
        createEditCategoryPage.saveCategoriesOrder();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /// FILL /////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    @And("Fill category name")
    public void fillCategoryName()
    {
        createEditCategoryPage.fillName(categoryName);
    }

    @Then("Edit category name")
    public void editCategoryName()
    {
        createEditCategoryPage.fillName(updatedCategoryName);
    }

    @And("Fill subcategory name")
    public void fillSubcategoryName()
    {
        createEditCategoryPage.fillName(subCategoryName);
    }

    @And("Set parent category")
    public void setParentCategory()
    {
        createEditCategoryPage.fillParentCategory(updatedCategoryName);
    }

    @And("Send category form")
    public void sendCategoryForm()
    {
        createEditCategoryPage.sendForm();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /// CHECK ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    @Then("Check success message")
    public void checkSuccessMessage()
    {
        createEditCategoryPage.checkSuccessMessage("Kategória bola uložená do databázy");
    }

    @And("Check category exists")
    public void checkCategoryExists()
    {
        createEditCategoryPage.checkCategoryExists(categoryName);
    }

    @And("Check error message related to category already exists")
    public void checkErrorMessage()
    {
        createEditCategoryPage.checkErrorMsg("Kategória s rovnakým názvom už existuje");
    }

    @And("Check category is not visible")
    public void checkCategoryIsNotVisible()
    {
        createEditCategoryPage.checkCategoryVisibility(false);
    }

    @And("Check expected category name")
    public void CheckExpectedCategoryName()
    {
        createEditCategoryPage.checkExpectedCategoryName(categoryName);
    }

    @And("Check category has been updated")
    public void CheckEditedCategoryName()
    {
        createEditCategoryPage.checkCategoryExists(updatedCategoryName);
    }

    @And("Check parent category")
    public void checkParentCategory()
    {
        createEditCategoryPage.checkParentCategoryExists(updatedCategoryName);
    }

    @Then("Check sort success message")
    public void checkSortSuccessMessage()
    {
        createEditCategoryPage.checkSuccessMessage("Poradie položiek bolo upravené");
    }

    @And("Check if subcategory is above the parent category")
    public void checkIfSubcategoryIsAboveTheParentCategory()
    {
        createEditCategoryPage.checkIfSubcategoryIsAboveTheParentCategory(updatedCategoryName, subCategoryName);
    }

    @And("Check if test category is inside the category")
    public void checkIfTestCategoryIsInsideTheCategory() throws InterruptedException
    {
        createEditCategoryPage.checkIfSubcategoryIsInsideTheParentCategory(updatedCategoryName, subCategoryName);
        sleep(10000);
    }
}

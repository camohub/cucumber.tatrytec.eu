package steps.admin;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.admin.CreateEditCategoryPage;
import steps.BaseAdminSteps;


public class CreateEditCategoriesSteps extends BaseAdminSteps
{

    CreateEditCategoryPage createEditCategoryPage;

    public static String testText = "Selenium test";  // Statis because of use in



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
        createEditCategoryPage.clickOnEditCategoryIcon(testText);
    }

    @Then("Click on edit subcategory icon")
    public void clickOnEditSubCategoryIcon()
    {
        createEditCategoryPage.clickOnEditCategoryIcon(testText + " subcategory");
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /// FILL /////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    @And("Fill category name")
    public void fillCategoryName()
    {
        createEditCategoryPage.fillName(testText);
    }

    @Then("Edit category name")
    public void editCategoryName()
    {
        createEditCategoryPage.fillName(testText + " 2");
    }

    @And("Fill subcategory name")
    public void fillSubcategoryName()
    {
        createEditCategoryPage.fillName(testText + " subcategory");
    }

    @And("Set parent category")
    public void setParentCategory()
    {
        createEditCategoryPage.fillName(testText + " subcategory");
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
        createEditCategoryPage.checkCategoryExists(testText);
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
        createEditCategoryPage.checkExpectedCategoryName(testText);
    }

    @And("Check category has been updated")
    public void CheckEditedCategoryName()
    {
        createEditCategoryPage.checkCategoryExists(testText + " 2");
    }

    @And("Check parent category")
    public void checkParentCategory()
    {
        createEditCategoryPage.checkParentCategoryExists(testText + " 2");
    }
}

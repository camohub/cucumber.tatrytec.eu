package steps.admin;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.admin.CreateEditCategoryPage;
import services.PageSingletonService;

import static java.lang.Thread.sleep;


public class CreateEditCategoriesSteps extends BaseAdminSteps
{

    CreateEditCategoryPage createEditCategoryPage;


    /**
     * Constructor
     */
    public CreateEditCategoriesSteps()
    {
        createEditCategoryPage = PageSingletonService.getCreateEditCategoryPage();
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

    @Then("Click on category {string} edit icon")
    public void clickOnEditSubCategoryIcon(String title)
    {
        createEditCategoryPage.clickOnEditCategoryIcon(title);
    }

    @Then("Click on category {string} list open icon")
    public void clickOnListOpenIcon(String title)
    {
        createEditCategoryPage.clickOnListOpenIcon(title);
    }

    /**
     * Current state is subCategory inside the parentCategory
     * Expected state is subCategory is outside and above the parentCategory
     */
    @Then("Drag subcategory out of parent {string} category")
    public void dragSubcategoryOutOfParentCategory(String parentTitle)
    {
        createEditCategoryPage.dragSubcategoryOutOfParentCategory(parentTitle);
    }

    /**
     * Current state is subCategory is outside and above the parentCategory
     * Expected state is subCategory is back inside the parentCategory
     */
    @Then("Drag subcategory {string} back inside the parent {string} category")
    public void dragSubCategoryBackToTheParentCategory(String subTitle, String parentTitle)
    {
        createEditCategoryPage.dragSubCategoryInsideTheParentCategory(parentTitle, subTitle);
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

    @And("Fill category name {string}")
    public void fillCategoryName(String title)
    {
        createEditCategoryPage.fillName(title);
    }

    @And("Set parent category {string}")
    public void setParentCategory(String title)
    {
        createEditCategoryPage.fillParentCategory(title);
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

    @And("Check category exists {string}")
    public void checkCategoryExists(String title)
    {
        createEditCategoryPage.checkCategoryExists(title);
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

    @And("Check expected category name {string}")
    public void checkExpectedCategoryName(String title)
    {
        createEditCategoryPage.checkExpectedCategoryName(title);
    }

    @And("Check category has been updated {string}")
    public void checkEditedCategoryName(String title)
    {
        createEditCategoryPage.checkCategoryExists(title);
    }

    @And("Check parent category {string}")
    public void checkParentCategory(String title)
    {
        createEditCategoryPage.checkParentCategoryIsSelected(title);
    }

    @Then("Check sort success message")
    public void checkSortSuccessMessage()
    {
        createEditCategoryPage.checkSuccessMessage("Poradie položiek bolo upravené");
    }

    @And("Check if subcategory {string} is above the parent {string} category")
    public void checkIfSubcategoryIsAboveTheParentCategory(String titleMain, String titleSub)
    {
        createEditCategoryPage.checkIfSubcategoryIsAboveTheParentCategory(titleMain, titleSub);
    }

    @And("Check if category {string} is inside the category {string}")
    public void checkIfTestCategoryIsInsideTheCategory(String parentTitle, String subTitle) throws InterruptedException
    {
        createEditCategoryPage.checkIfSubcategoryIsInsideTheParentCategory(parentTitle, subTitle);
    }
}

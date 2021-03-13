package steps.admin;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.admin.CreateEditArticlePage;
import steps.BaseAdminSteps;


public class CreateEditArticleSteps extends BaseAdminSteps
{

    CreateEditArticlePage createEditArticlePage;

    String testText = "Test text";


    public CreateEditArticleSteps()
    {
        createEditArticlePage = new CreateEditArticlePage();
    }

    ///////////////////////////////////////////////////////////////////////
    /// LINKS ////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////

    @When("Click on new article link")
    public void clickOnNewArticleLink()
    {
        createEditArticlePage.openCreateArticlePage();
    }

    @When("Click on edit articles link")
    public void clickOnEditArticlesLink()
    {
        createEditArticlePage.openEditArticlesPage();
    }

    @When("Click on edit icon")
    public void clickOnEditArticleIcon()
    {
        createEditArticlePage.clickOnEditArticleIcon(testText);
    }

    /////////////////////////////////////////////////////////////////////
    /// FILL FORM //////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    @And("Fill meta description")
    public void fillMetaDescription()
    {
        createEditArticlePage.fillMetaDesc(testText);
    }

    @And("Fill title")
    public void fillTitle()
    {
        createEditArticlePage.fillTitle(testText);
    }

    @And("Fill perex")
    public void perex()
    {
        createEditArticlePage.fillPerex("<h2>" + testText + "</h2>");
    }

    @And("Fill text")
    public void fillText()
    {
        createEditArticlePage.fillText("<h2>" + testText + "</h2>");
    }

    @And("Fill categories")
    public void fillCategories()
    {
        createEditArticlePage.fillCategories("124", "125");
    }

    @Then("Edit meta description")
    public void editMetaDescription()
    {
        createEditArticlePage.fillMetaDesc(testText + " 2");
    }

    @Then("Edit title")
    public void editTitle()
    {
        createEditArticlePage.fillTitle(testText);
    }

    @Then("Edit perex")
    public void editPerex()
    {
        createEditArticlePage.fillPerex("<h2>" + testText + " 2</h2>");
    }

    @Then("Edit text")
    public void editText()
    {
        createEditArticlePage.fillText("<h2>" + testText + " 2</h2>");
    }

    @Then("Edit categories")
    public void editCategories()
    {
        createEditArticlePage.fillCategories("125", "126");
    }

    @And("Send form")
    public void sendForm()
    {
        createEditArticlePage.sendForm();
    }


    ////////////////////////////////////////////////////////////////////////
    /// CHECKS ////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////

    @Then("Check success message")
    public void checkSuccessMessage()
    {
        createEditArticlePage.checkSuccessMessage();
    }

    @And("Check article exists")
    public void checkArticleExists()
    {
        createEditArticlePage.checkArticleExists(testText);
    }

    @Then("Check error message related to title already exists")
    public void checkErrorMessageTitleExists()
    {
        createEditArticlePage.checkErrorMsg("Článok s rovnakým názvom už existuje");
    }

    @And("Check article has been updated")
    public void checkArticleHasBeenUpdated()
    {
        createEditArticlePage.checkArticleExists(testText + " 2");
    }
}

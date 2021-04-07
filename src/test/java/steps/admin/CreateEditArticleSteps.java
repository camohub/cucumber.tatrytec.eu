package steps.admin;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.admin.ArticlesFilterTablePage;
import pages.admin.CreateEditArticlePage;
import services.PageSingletonService;


public class CreateEditArticleSteps extends BaseAdminSteps
{

    CreateEditArticlePage createEditArticlePage;

    ArticlesFilterTablePage articlesFilterTablePage;

    public String OPEN_ARTICLES_ADMIN_URL = "/admin/articles";

    String testText = "Selenium test";


    /**
     * Constructor
     */
    public CreateEditArticleSteps()
    {
        createEditArticlePage = PageSingletonService.getCreateEditArticlePage();
        articlesFilterTablePage = PageSingletonService.getArticlesFilterTablePage();
    }


    @Given("Open articles admin page")
    public void openArticlesAdminPage()
    {
        openPage(OPEN_ARTICLES_ADMIN_URL);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /// LINKS ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    @When("Click on new article link")
    public void clickOnNewArticleLink()
    {
        adminPage.openCreateArticlePage();
    }

    @When("Click on edit articles link")
    public void clickOnEditArticlesLink()
    {
        adminPage.openEditArticlesPage();
    }

    @When("Click on edit icon")
    public void clickOnEditArticleIcon()
    {
        articlesFilterTablePage.clickOnEditArticleIcon(testText);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    /// FILL FORM /////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////

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
    public void fillPerex()
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
        createEditArticlePage.fillTitle(testText + " 2");
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


    ///////////////////////////////////////////////////////////////////////////////////////////
    /// CHECKS ///////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    @Then("Check article success message")
    public void checkSuccessMessage()
    {
        createEditArticlePage.checkSuccessMessage("Článok bol uložený");
    }

    @And("Check article exists")
    public void checkArticleExists()
    {
        articlesFilterTablePage.checkArticleExists(testText);
    }

    @Then("Check created title")
    public void checkTitleValue()
    {
        createEditArticlePage.checkArticleTitle(testText);
    }

    @Then("Check crated meta description")
    public void checkMetaDescValue()
    {
        createEditArticlePage.checkArticleMetaDesc(testText);
    }

    @Then("Check crated perex")
    public void checkPerexValue()
    {
        createEditArticlePage.checkArticlePerex("<h2>" + testText + "</h2>");
    }

    @Then("Check crated text")
    public void checkTextValue()
    {
        createEditArticlePage.checkArticleText("<h2>" + testText + "</h2>");
    }

    @Then("Check created categories")
    public void checkCategoriesValues()
    {
        createEditArticlePage.checkArticleCategories("124", "125");
    }

    @Then("Check error message related to title already exists")
    public void checkErrorMessageTitleExists()
    {
        createEditArticlePage.checkErrorMsg("Článok s rovnakým názvom už existuje");
    }

    @And("Check article has been updated")
    public void checkArticleHasBeenUpdated()
    {
        articlesFilterTablePage.checkArticleExists(testText + " 2");
    }
}

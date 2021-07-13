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

    public String OPEN_ARTICLES_ADMIN_URL = "https://tatrytec.eu/admin/articles";


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

    @When("Click on edit icon {string}")
    public void clickOnEditArticleIcon(String title)
    {
        articlesFilterTablePage.clickOnEditArticleIcon(title);
    }

    @And("Open article comments admin")
    public void clickOnArticleCommentsIcon()
    {
        articlesFilterTablePage.clickOnArticleCommentsIcon();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    /// FILL FORM /////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////

    @And("Fill meta description {string}")
    public void fillMetaDescription(String desc)
    {
        createEditArticlePage.fillMetaDesc(desc);
    }

    @And("Fill title {string}")
    public void fillTitle(String title)
    {
        createEditArticlePage.fillTitle(title);
    }

    @And("Fill perex {string}")
    public void fillPerex(String perex)
    {
        createEditArticlePage.fillPerex("<h2>" + perex + "</h2>");
    }

    @And("Fill text {string}")
    public void fillText(String text)
    {
        createEditArticlePage.fillText("<h2>" + text + "</h2>");
    }

    @And("Fill categories")
    public void fillCategories()
    {
        createEditArticlePage.fillCategories("124", "125");
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

    @And("Check article exists {string}")
    public void checkArticleExists(String title)
    {
        articlesFilterTablePage.checkArticleExists(title);
    }

    @Then("Check created title {string}")
    public void checkTitleValue(String title)
    {
        createEditArticlePage.checkArticleTitle(title);
    }

    @Then("Check crated meta description {string}")
    public void checkMetaDescValue(String desc)
    {
        createEditArticlePage.checkArticleMetaDesc(desc);
    }

    @Then("Check crated perex {string}")
    public void checkPerexValue(String perex)
    {
        createEditArticlePage.checkArticlePerex("<h2>" + perex + "</h2>");
    }

    @Then("Check crated text {string}")
    public void checkTextValue(String text)
    {
        createEditArticlePage.checkArticleText("<h2>" + text + "</h2>");
    }

    @Then("Check created categories")
    public void checkCategoriesValues()
    {
        createEditArticlePage.checkArticleCategories("124", "125");
    }

    @And("Check article has been updated {string}")
    public void checkArticleHasBeenUpdated(String title)
    {
        articlesFilterTablePage.checkArticleExists(title);
    }
}

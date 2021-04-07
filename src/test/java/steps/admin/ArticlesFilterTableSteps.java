package steps.admin;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.admin.ArticlesFilterTablePage;
import services.PageSingletonService;

import java.text.ParseException;


public class ArticlesFilterTableSteps extends BaseAdminSteps
{

    private final ArticlesFilterTablePage articlesFilterTablePage;

    public static String USER_NAME = "Selenium Test User";


    public ArticlesFilterTableSteps()
    {
        articlesFilterTablePage = PageSingletonService.getArticlesFilterTablePage();
    }


    @And("Select Test User in user name filter")
    public void selectTestUserInUserNameFilter()
    {
        articlesFilterTablePage.selectUser(USER_NAME);
    }

    @And("Fill existing title in title input")
    public void fillExistingTitleInTitleInput()
    {
        articlesFilterTablePage.fillTitleFromTable();
    }

    @And("Select order by date ascending")
    public void selectOrderByDateAscending()
    {
        articlesFilterTablePage.selectOrderByDateAsc();
    }

    @And("Select order by date descending")
    public void selectOrderByDateDescending()
    {
        articlesFilterTablePage.selectOrderByDateDesc();
    }

    @And("Send filter form")
    public void sendFilterForm()
    {
        articlesFilterTablePage.sendForm();
    }


    /////////////////////////////////////////////////////////////////////////////////////
    /// CHECK //////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////

    @Then("Articles table should contain only Test User articles")
    public void articlesTableShouldContainOnlyTestUserArticles()
    {
        articlesFilterTablePage.checkFilteredUser(USER_NAME);
    }

    @Then("Articles table should contain only filtered title")
    public void articlesTableShouldContainOnlyFilteredTitle()
    {
        articlesFilterTablePage.checkFilteredTitle();
    }

    @Then("Articles table should be sorted by date ascending")
    public void articlesTableShouldBeSortedByDateAscending() throws ParseException
    {
        articlesFilterTablePage.checkFilteredDateAsc();
    }

    @Then("Articles table should be sorted by date descending")
    public void articlesTableShouldBeSortedByDateDescending() throws ParseException
    {
        articlesFilterTablePage.checkFilteredDateDesc();
    }
}

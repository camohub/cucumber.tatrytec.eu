package steps.admin;


import io.cucumber.java.en.Then;
import pages.admin.ArticleCommentsPage;
import services.PageSingletonService;


public class ArticleCommentsSteps extends BaseAdminSteps
{

    ArticleCommentsPage articleCommentsPage;


    /**
     * Constructor
     */
    public ArticleCommentsSteps()
    {
        articleCommentsPage = PageSingletonService.getAdminArticleCommentsPage();
    }


    ///////////////////////////////////////////////////////////////////////////////////////////
    /// LINKS ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    @Then("Delete comment {string}")
    public void deleteComment(String comment)
    {
        articleCommentsPage.clickOnDeleteIcon(comment);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /// CHECKS ///////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    @Then("Check invisible status of comment {string}")
    public void checkInvisibleCommentStatus(String comment)
    {
        articleCommentsPage.checkInvisibleCommentStatus(comment);
    }

}

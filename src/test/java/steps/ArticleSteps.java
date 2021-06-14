package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ArticlePage;
import pages.GoogleLoginPage;
import services.PageSingletonService;


public class ArticleSteps extends BaseSteps
{

    protected ArticlePage articlePage;

    protected GoogleLoginPage googleLoginPage;


    public ArticleSteps()
    {
        articlePage = PageSingletonService.getArticlePage();
        googleLoginPage = PageSingletonService.getGoogleLoginPage();
    }

    @And("Click on Github login button")
    public void clickOnGithubLoginButton()
    {
        articlePage.clickOnGithubLoginBtn();
    }

    @And("Click on Facebook login button")
    public void clickOnFacebookLoginButton()
    {
        articlePage.clickOnFacebookLoginBtn();
    }

    @And("Click on Google login button")
    public void clickOnGoogleLoginButton()
    {
        articlePage.clickOnGoogleLoginBtn();
    }

    @And("Write a comment {string}")
    public void writeAComment(String comment)
    {
        articlePage.writeComment(comment);
    }

    @Then("Save comment")
    public void saveComment()
    {
        articlePage.saveComment();
    }

    @And("Check the comment exists {string}")
    public void checkCommentExists(String comment)
    {
        articlePage.checkCommentExists(comment);
    }
}

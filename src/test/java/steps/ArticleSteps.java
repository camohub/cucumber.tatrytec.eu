package steps;


import io.cucumber.java.en.And;
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
}

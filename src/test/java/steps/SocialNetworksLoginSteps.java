package steps;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.ArticlePage;
import pages.FacebookLoginPage;
import pages.GithubLoginPage;
import pages.GoogleLoginPage;
import services.PageSingletonService;
import static java.time.Duration.ofSeconds;


public class SocialNetworksLoginSteps extends BaseSteps
{

    protected ArticlePage articlePage;

    protected GoogleLoginPage googleLoginPage;

    protected GithubLoginPage githubLoginPage;

    protected FacebookLoginPage facebookLoginPage;


    public SocialNetworksLoginSteps()
    {
        articlePage = PageSingletonService.getArticlePage();
        googleLoginPage = PageSingletonService.getGoogleLoginPage();
        githubLoginPage = PageSingletonService.getGithubLoginPage();
        facebookLoginPage = PageSingletonService.getFacebookLoginPage();
    }


    @And("Fill Github login form")
    public void fillGithubLoginForm()
    {
        // If browser does not remember previous login
        if( !elementExists(By.cssSelector("#alerts-wrapper .alert-success"), 7))
        {
            if( elementExists( By.name("login"), 7) )
            {
                String email = conf.getString("login.githubEmail");
                String pass = conf.getString("login.githubPassword");
                githubLoginPage.fillAndSendForm(email, pass);
            }
        }
    }


    @And("Fill Facebook login form")
    public void fillFacebookLoginForm()
    {
        // If browser does not remember previous login
        if( !elementExists(By.cssSelector("#alerts-wrapper .alert-success"), 7))
        {
            if( elementExists( By.name("email"), 7) )
            {
                String email = conf.getString("login.facebookEmail");
                String pass = conf.getString("login.facebookPassword");
                facebookLoginPage.fillAndSendForm(email, pass);
            }
        }
    }


    @And("Fill Google login form")
    public void fillGoogleLoginForm()
    {
        // If browser does not remember previous login
        if( !elementExists(By.cssSelector("#alerts-wrapper .alert-success"), 7))
        {
            if( elementExists( By.cssSelector(".d2laFc"), 7) )
            {
                googleLoginPage.selectAccount();
            }
            if( elementExists( By.name("identifier"), 7) )
            {
                sleep(4000);
                googleLoginPage.fillEmail(conf.getString("login.googleEmail"));
            }
            if( elementExists( By.name("password"), 7) )
            {
                sleep(4000);
                googleLoginPage.fillPassword(conf.getString("login.googlePassword"));
            }
        }
    }
}

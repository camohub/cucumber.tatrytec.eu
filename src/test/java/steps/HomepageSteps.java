
package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.HomepagePage;
import services.PageSingletonService;

import static com.codeborne.selenide.Selenide.$;


public class HomepageSteps extends BaseSteps
{

    public String OPEN_URL = "?test=parameter";

    private int loginsCount = 0;


    @Given("Open homepage")
    public void openHomepage()
    {
        openPage(OPEN_URL);
    }


    @Given("Open article detail")
    public void openArticleDetail()
    {
        homepagePage.openArticleDetail();
    }


    @Given("User is logged in")
    public void logIn()
    {
        openPage(OPEN_URL);
        homepagePage.login(conf.getString("login.email"), conf.getString("login.password"));

        // Sometimes login is invalid so lets try it ones again.
        if( !elementExists(By.cssSelector("#alerts-wrapper .alert-success"), 30) && ++loginsCount < 2)
        {
            logIn();
            return;
        }
    }


    @And("Check header")
    public void checkHeader()
    {
        homepagePage.testHeader();
    }


    @And("Check side menu")
    public void checkSideMenu()
    {
        homepagePage.testMenu();
    }


    @And("Check articles count")
    public void checkArticlesCount()
    {
        homepagePage.testArticles();
    }


    @And("Check paginator")
    public void checkPaginator()
    {
        homepagePage.testPagination();
    }
}

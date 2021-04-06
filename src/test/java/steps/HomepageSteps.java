
package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.HomepagePage;
import services.PageSingletonService;

import static com.codeborne.selenide.Selenide.$;


public class HomepageSteps extends BaseSteps
{

    public String OPEN_URL = "?test=parameter";


    @Given("Open homepage")
    public void openHomepage()
    {
        openPage(OPEN_URL);
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

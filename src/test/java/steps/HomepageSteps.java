
package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.HomepagePage;

import static com.codeborne.selenide.Selenide.$;


public class HomepageSteps extends BaseSteps
{

    public HomepagePage homePage;

    public String OPEN_URL = "?aaaaaaaaaaaaa=bbbbbbbbbbbbb";


    @Given("Open homepage to test elements")
    public void openHomepage()
    {
        homePage = new HomepagePage();
    }


    @And("Check header")
    public void checkHeader()
    {
        homePage.testHeader();
    }


    @And("Check side menu")
    public void checkSideMenu()
    {
        homePage.testMenu();
    }


    @And("Check articles count")
    public void checkArticlesCount()
    {
        homePage.testArticles();
    }


    @And("Check paginator")
    public void checkPaginator()
    {
        homePage.testPagination();
    }
}

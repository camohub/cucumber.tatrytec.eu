
package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomepagePage;


public class HomepageSteps extends BaseSteps
{

    public HomepagePage homePage;


    @When("Simple open homepage")
    public void simpleOpenHomepage()
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

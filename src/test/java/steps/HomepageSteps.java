
package steps;


import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomepagePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;


public class HomepageSteps extends BaseSteps
{

    public HomepagePage homePage;

    public String OPEN_URL = "?aaaaaaaaaaaaa=bbbbbbbbbbbbb";


    @When("Simple open homepage")
    public void simpleOpenHomepage()
    {
        openPage(OPEN_URL);
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

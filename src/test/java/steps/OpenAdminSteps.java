package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminPage;
import pages.HomepagePage;
import pages.LoginPage;


public class OpenAdminSteps
{

    AdminPage page;


    public OpenAdminSteps()
    {
        page = new AdminPage();
    }


    @Given("Login with valid credentials")
    public void loginWithValidCredentials()
    {
        page.login();
    }


    @When("Click on admin link")
    public void clickOnAdminLink()
    {
        page.clickOnAdminLink();
    }


    @Then("Check admin page")
    public void checkAdminPage()
    {
        page.checkAdminPage();
    }

}

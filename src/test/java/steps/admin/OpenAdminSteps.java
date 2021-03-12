package steps.admin;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.admin.AdminPage;
import steps.BaseSteps;


public class OpenAdminSteps extends BaseSteps
{

    AdminPage adminPage;


    public OpenAdminSteps()
    {
        openPage(OPEN_URL);
        adminPage = new AdminPage();
    }


    @Given("Login with valid credentials")
    public void loginWithValidCredentials()
    {
        adminPage.login(validEmail, validPassword);
    }


    @When("Click on admin link")
    public void clickOnAdminLink()
    {
        adminPage.clickOnAdminLink();
    }


    @Then("Check admin page")
    public void checkAdminPage()
    {
        adminPage.checkAdminPage();
    }

}

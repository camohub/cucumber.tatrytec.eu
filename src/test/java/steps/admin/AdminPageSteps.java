package steps.admin;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.admin.CreateEditArticlePage;


public class AdminPageSteps extends BaseAdminSteps
{

    @Given("User is logged in and is on admin page")
    public void logInAndOpenAdminPage()
    {
        openPage(OPEN_URL);
        homepagePage.login(conf.getString("login.email"), conf.getString("login.password"));
        adminPage.clickOnAdminLink();
    }

}

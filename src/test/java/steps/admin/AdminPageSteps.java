package steps.admin;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.admin.CreateEditArticlePage;


public class AdminPageSteps extends BaseAdminSteps
{

    private int loginsCount = 0;


    @Given("User is logged in and is on admin page")
    public void logInAndOpenAdminPage()
    {
        openPage(OPEN_URL);
        homepagePage.login(conf.getString("login.email"), conf.getString("login.password"));

        // Sometimes login is invalid so lets try it ones again.
        if( !elementExists(By.cssSelector("#alerts-wrapper .alert-success")) && ++loginsCount < 2)
        {
            logInAndOpenAdminPage();
            return;
        }

        adminPage.clickOnAdminLink();
    }

}

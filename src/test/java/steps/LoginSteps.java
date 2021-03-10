
package steps;


import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;


public class LoginSteps extends BaseSteps
{
    LoginPage loginPage;

    @Before
    public void setup()
    {

    }

    @After
    public void tearDown()
    {

    }


    @Given("Open homepage")
    public void openHomepage()
    {
        loginPage = new LoginPage();
        loginPage.openLoginModal();
    }


    @When("Fill and send invalid login form {word} {word}")
    public void fillAndSendInvalidLoginForm(String email, String password)
    {
        loginPage.fillEmail(email);
        loginPage.fillPassword(password);
        loginPage.sendForm();
    }


    @When("Fill and send valid login form")
    public void fillAndSendValidLoginForm()
    {
        loginPage.fillEmail(loginPage.validEmail);
        loginPage.fillPassword(loginPage.validPassword);
        loginPage.sendForm();
    }


    @Then("See success message")
    public void seeSuccessMessage()
    {
        loginPage.checkLoginResponse("#alerts-wrapper .alert-success", "Vitajte na palube");
    }

    @Then("See error message")
    public void seeErrorMessage()
    {
        loginPage.checkLoginResponse("#loginModal .alert-danger", "Nesprávny email, alebo heslo.");
    }
}

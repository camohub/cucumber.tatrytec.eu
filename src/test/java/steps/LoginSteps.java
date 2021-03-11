
package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomepagePage;


public class LoginSteps extends BaseSteps
{

    HomepagePage homepagePage;


    @Given("Open homepage")
    public void openHomepage()
    {
        openPage(OPEN_URL);
        homepagePage = new HomepagePage();
    }

    @When("Open login modal")
    public void openLoginModal()
    {
        homepagePage.openLoginModal();
    }

    //@And("Fill and send invalid login form ([^ ]+) ([^ ])")
    @And("Fill and send invalid login form {word} {word}")
    public void fillAndSendInvalidLoginForm(String email, String password)
    {
        homepagePage.fillEmail(email);
        homepagePage.fillPassword(password);
        homepagePage.sendForm();
    }

    @When("Fill and send valid login form")
    public void fillAndSendValidLoginForm()
    {
        homepagePage.fillEmail(validEmail);
        homepagePage.fillPassword(validPassword);
        homepagePage.sendForm();
    }

    @Then("See success message")
    public void seeSuccessMessage()
    {
        homepagePage.checkLoginResponse("#alerts-wrapper .alert-success", "Vitajte na palube");
    }

    @Then("See error message")
    public void seeErrorMessage()
    {
        homepagePage.checkLoginResponse("#loginModal .alert-danger", "Nesprávny email, alebo heslo.");
    }
}

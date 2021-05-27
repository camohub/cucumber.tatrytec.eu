package steps;


import io.cucumber.java.en.Then;

public class UniversalSteps extends BaseSteps
{


    public UniversalSteps()
    {

    }


    @Then("Check success")
    public void checkSuccess()
    {
        homepagePage.checkSuccess();
    }


    @Then("Check success {string}")
    public void checkSuccess(String msg)
    {
        homepagePage.checkSuccessMessage(msg);
    }

    @Then("Check error")
    public void checkError()
    {
        homepagePage.checkError();
    }

    @Then("Check error {string}")
    public void checkError(String msg)
    {
        homepagePage.checkErrorMessage(msg);
    }
}

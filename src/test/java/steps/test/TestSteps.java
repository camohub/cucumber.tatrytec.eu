package steps.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomepagePage;
import steps.BaseSteps;

public class TestSteps extends BaseSteps
{


    public TestSteps()
    {
        openPage(OPEN_URL);
    }

    @When("Test")
    public void test() {
        System.out.println("Test");
    }

    @Then("Print test")
    public void printTest() {
        System.out.println("Test");
    }
}

package steps.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomepagePage;
import steps.BaseSteps;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSteps extends BaseSteps
{


    public TestSteps()
    {
        openPage(OPEN_URL);
    }

    @When("Test")
    public void test() throws ParseException
    {
        System.out.println("Test");

    }

    @Then("Print test")
    public void printTest() {
        System.out.println("Hello world!");
    }
}

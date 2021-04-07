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
        // if first < second then -1
        // if first > second then 1
        // if first == second then 0
        System.out.println("24.3. 2016".compareTo("23.6. 2016"));
        System.out.println("23.6. 2016".compareTo("24.3. 2016"));



    }

    @Then("Print test")
    public void printTest() {
        System.out.println("Test");
    }
}

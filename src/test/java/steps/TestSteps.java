package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomepagePage;
import steps.BaseSteps;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static java.time.Duration.ofSeconds;

public class TestSteps extends BaseSteps
{


    public TestSteps()
    {
        openPage(OPEN_URL);
    }

    @When("Test")
    public void test() throws ParseException
    {
        homepagePage.testHeader();
    }

    @Then("Print test")
    public void printTest() {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Then("Print test 2")
    public void printTest2() {
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
    }
}

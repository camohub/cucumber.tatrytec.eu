
package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "@target/reports/failed.txt",
    glue = {"steps", "hooks"},
    plugin = {"pretty", "json:target/reports/failed-tests-rerun-cucumber.json", "html:target/reports/failed-tests-rerun-cucumber.html"}
)
public class FailedTestsRunner
{

}

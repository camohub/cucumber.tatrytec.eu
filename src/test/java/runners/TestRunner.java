
package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/features/Test.feature",
    glue = {"steps", "hooks"},
    plugin = {"pretty", "json:target/reports/cucumber.json"},
    monochrome = true
)
public class TestRunner
{

}

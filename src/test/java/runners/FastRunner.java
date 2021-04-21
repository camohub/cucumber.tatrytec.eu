
package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/features/",
    glue = {"steps", "hooks"},
    tags = "@test",
    plugin = {"pretty", "rerun:target/reports/failed.txt", "json:target/reports/cucumber.json", "html:target/reports/cucumber.html"}
)
public class FastRunner
{

}

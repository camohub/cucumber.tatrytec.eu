
package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/features/",
    glue = {"steps", "hooks"},
    tags = "@homepage or @test",
    plugin = {"pretty", "json:target/reports/cucumber.json"}
)
public class FastRunner
{

}

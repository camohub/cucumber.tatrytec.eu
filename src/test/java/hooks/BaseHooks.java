
package hooks;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.typesafe.config.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import services.ConfigSingletonService;
import steps.BaseSteps;

import java.util.Date;
import static com.codeborne.selenide.Selenide.screenshot;


public class BaseHooks
{

    protected static Scenario scenario;

    protected static Config conf = ConfigSingletonService.conf();

    /////////////////////////////////////////////////////////////////////////////////////////////
    /// @Before ////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////

    @Before(order=1)
    public void setup(Scenario sc)
    {
        scenario = sc;
    }


    // Conf. has to be removed in @After otherwise it persists in browser settings.
    @Before("@maximize")
    public void maximizeOn()
    {
        Configuration.startMaximized = true;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    /// @After /////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////

    @After("@maximize")
    public void maximizeOff()
    {
        Configuration.startMaximized = false;
    }


    @After(order=2)  // @After hooks run in revert order - 3 2 1 0
    public void onFail()
    {
        if( scenario.isFailed() )
        {
            byte[] data = screenshot(OutputType.BYTES);
            String fileName = scenario.getName().replaceAll("[^\\w]+","-") + "-" + (new Date()).getTime();
            scenario.attach(data, "image/png", fileName);
        }
    }


    @After(/*value="@last", */order=1)  // @After hooks run in revert order - 3 2 1 0
    public void tearDown()
    {
        WebDriver driver = WebDriverRunner.getWebDriver();
        driver.close();
        driver.quit();
        //BaseSteps.isLoggedIn = false;
    }

}

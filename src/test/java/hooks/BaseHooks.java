
package hooks;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import java.util.Date;

import static com.codeborne.selenide.Selenide.screenshot;


public class BaseHooks
{

    public static Scenario scenario;

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


    @After("@maximize")
    public void maximizeOff()
    {
        Configuration.startMaximized = false;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    /// @After /////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////

    @After(order=2)  // @After order runs in revert order - 3 2 1 0
    public void onFail()
    {
        if( scenario.isFailed() )
        {
            byte[] data = screenshot(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName() + "-" + (new Date()).getTime());
        }
    }


    @After(order=1)  // @After order runs in revert order - 3 2 1 0
    public void tearDown()
    {
        WebDriver driver = WebDriverRunner.getWebDriver();
        driver.close();
        driver.quit();
    }

}

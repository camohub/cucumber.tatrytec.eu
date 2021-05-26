
package hooks;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.typesafe.config.Config;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import services.ConfigSingletonService;
import services.WebDriverService;
import java.util.Date;
import static com.codeborne.selenide.Selenide.screenshot;

/**
 * This class and its instance is shared between scenarios!!!
 * It means every instance variable is shared across the current running scenarios!!!
 */
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
        // BAD IDEA!!! It seems hooks class instance is a singleton shared with all scenarios.
        //scenario = sc;
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

    @After(order=5)  // @After hooks run in revert order - 3 2 1 0
    public void onFail(Scenario scenario)
    {
        // TODO: remove screenshots on success
        if( scenario.isFailed() || !scenario.isFailed() )
        {
            byte[] data = screenshot(OutputType.BYTES);
            String fileName = scenario.getName().replaceAll("[^\\w]+","-") + "-" + (new Date()).getTime();
            scenario.attach(data, "image/png", fileName);
        }
    }


    @After(value="@maximize", order=4)
    public void maximizeOff()
    {
        Configuration.startMaximized = false;
    }


    @After(order=2)
    public void deleteCookies()
    {
        WebDriver driver = WebDriverRunner.getWebDriver();
        driver.manage().deleteAllCookies();
    }


    @After(value="@last", order=1)  // @After hooks run in revert order - 3 2 1 0
    public void closeWindow(Scenario scenario)
    {
        System.out.println("[INFO] ------------------------------------------------------------------------");
        System.out.println("[INFO]  Hook @After @last ");
        System.out.println("[INFO] ------------------------------------------------------------------------");
        WebDriverService.closeBrowser();
    }

}

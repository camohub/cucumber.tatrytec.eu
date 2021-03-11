
package hooks;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;


public class BaseHook
{

    @Before(order = 1)
    public void setup()
    {

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


    @After
    public void tearDown()
    {
        WebDriver driver = WebDriverRunner.getWebDriver();
        driver.close();
        driver.quit();
    }

}

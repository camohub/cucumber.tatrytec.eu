
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


    @Before(value = "@maximize", order = 2)
    public void maximize()
    {
        Configuration.startMaximized = true;
    }


    @After
    public void tearDown()
    {
        WebDriver driver = WebDriverRunner.getWebDriver();
        driver.close();
        driver.quit();
    }

}

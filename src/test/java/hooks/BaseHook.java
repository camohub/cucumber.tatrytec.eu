package hooks;


import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;


public class BaseHook
{

    @Before
    public void setup()
    {

    }


    @After
    public void tearDown()
    {
        WebDriver driver = WebDriverRunner.getWebDriver();
        driver.close();
        driver.quit();
    }

}

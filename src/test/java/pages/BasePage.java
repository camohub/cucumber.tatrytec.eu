
package pages;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.ScreenShooter;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;


public class BasePage
{

    public static String OPEN_URL = "";  // Needs to have empty string. Does not work without value or null.

    public String validEmail;

    public String validPassword;


    static {
        Configuration.remote = "http://127.0.0.1:4444/wd/hub";
        Configuration.baseUrl = "https://tatrytec.eu";
        //Configuration.startMaximized = true;
        //Configuration.headless = true;
        //Configuration.screenshots = false;
        //Configuration.holdBrowserOpen = true;
    }


    // Set screenshots only on fail. This is extension of native JUnit TestWatcher like above.
    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();


    public BasePage()
    {
        Config conf = ConfigFactory.load();  // resources/application.conf
        this.validPassword = conf.getString("login.password");
        this.validEmail = conf.getString("login.email");
    }


    public void login()
    {
        $("#sideMenu").find(byAttribute("data-target", "#loginModal")).click();

        SelenideElement modal = $("#loginModal");
        modal.find( byName("email") ).val(validEmail);
        modal.find( byName("password") ).val(validPassword);
        modal.find( byAttribute("type", "submit") ).click();
    }

}

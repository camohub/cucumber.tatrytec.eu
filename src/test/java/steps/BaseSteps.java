
package steps;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelectorMode;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.ScreenShooter;
import com.typesafe.config.Config;
import io.cucumber.java.en.Given;
import io.cucumber.junit.Cucumber;
import org.junit.ClassRule;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import pages.HomepagePage;
import pages.admin.AdminPage;
import services.ConfigSingletonService;
import services.PageSingletonService;

import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;


public class BaseSteps
{

    /* This is not allowed. Throws exception You're not allowed to extend classes that define Step Definitions or hooks
    @Before
    @After*/

    protected static Config conf = ConfigSingletonService.conf();  // resources/application.conf

    static {
        Configuration.remote = "http://127.0.0.1:4444";
        Configuration.baseUrl = "https://tatrytec.eu";
        Configuration.headless = conf.getBoolean("env.production");
        Configuration.reportsFolder = "target/reports/";
        Configuration.selectorMode = SelectorMode.Sizzle;
        //Configuration.startMaximized = true;  // use hook for tag @maximized
        //Configuration.screenshots = false;
        //Configuration.holdBrowserOpen = true;
        validPassword = conf.getString("login.password");
        validEmail = conf.getString("login.email");
        //System.setProperty("CUCUMBER_PUBLISH_TOKEN", conf.getString("cucumber-reports.token"));
    }

    public static String validPassword;
    public static String validEmail;


    public String OPEN_URL = "";


    public HomepagePage homepagePage;


    /**
     * Constructor
     */
    public BaseSteps()
    {
        homepagePage = PageSingletonService.getHomePage();
    }


    public void openPage(String url)
    {
        open(url);
        WebDriverRunner.getWebDriver().manage().timeouts().pageLoadTimeout(120, SECONDS);
        WebDriverRunner.getWebDriver().manage().timeouts().setScriptTimeout(120, SECONDS);
    }


    // Set screenshots only on fail. This is extension of native JUnit TestWatcher like above.
    //@Rule
    //public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

    // This is the JUnit way how to catch fail event.
    //@Rule
    //public TestWatcher failWatcher = new TestWatcher();

    // Set screenshots only on fail. This is extension of native JUnit TestWatcher like above.
    //@Rule
    //public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

    // Create test report as table.
    //@Rule
    //public TextReport textReport = new TextReport();

    // Reports all failed tests not only the first one.
    //@Rule
    //public SoftAsserts softAsserts = new SoftAsserts();


    /*@Before
    public void baseSetUp() throws MalformedURLException
    {
        //(new WebDriverService()).setDriver();

        //failWatcher.setTestClass(getClass().getSimpleName());
    }*/


    /*@After
    public void baseTearDown() throws IOException
    {
        // Is implemented in TestWatcher::finish()
    }*/

}


package steps;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.Rule;

import static com.codeborne.selenide.Selenide.*;


public class BaseSteps
{

    /* This is not not allowed. Throws exception You're not allowed to extend classes that define Step Definitions or hooks
    @Before
    @After*/


    // Set screenshots only on fail. This is extension of native JUnit TestWatcher like above.
    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();


    static {
        Configuration.remote = "http://127.0.0.1:4444/wd/hub";
        Configuration.baseUrl = "https://tatrytec.eu";
        Config conf = ConfigFactory.load();  // resources/application.conf
        validPassword = conf.getString("login.password");
        validEmail = conf.getString("login.email");
        //Configuration.startMaximized = true;  // use hook for tag @maximized
        //Configuration.headless = true;
        //Configuration.screenshots = false;
        //Configuration.holdBrowserOpen = true;
    }

    protected static String validPassword;
    protected static String validEmail;

    public String OPEN_URL = "";


    public void openPage(String url)
    {
        open(url);
    }

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

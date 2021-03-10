
package steps;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.TextReport;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import pages.LoginPage;

import java.io.IOException;
import java.net.MalformedURLException;


public class BaseSteps
{

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

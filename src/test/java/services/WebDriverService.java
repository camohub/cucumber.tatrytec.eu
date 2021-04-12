
package services;


import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;


public class WebDriverService
{

    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";

    public static final String HUB_URL = "http://127.0.0.1:4444";

    // browserstack.com is third party Selenium server hub
    public static final String BROWSERSTACK_HUB_URL = "https://vladimramaj1:LfPypf1dhvxbSNQsfV1X@hub-cloud.browserstack.com/wd/hub";


    /**
     * If does not use native Selenide driver we has to set it up in WebDriverRunner.setWebDriver(driver);
     * @throws MalformedURLException
     */
    public void setDriver() throws MalformedURLException
    {
        String browser = System.getProperty("browser");
        browser = browser == null ? "" : browser.toLowerCase();
        WebDriver driver = null;

        if (browser.equals(CHROME))
        {
            driver = new RemoteWebDriver(this.getRemoteUrl(), new ChromeOptions());
        }
        else if (browser.equals(FIREFOX))
        {
            driver = new RemoteWebDriver(this.getRemoteUrl(), new FirefoxOptions());
        }
        else
        {
            driver = new RemoteWebDriver(this.getRemoteUrl(), getChromeOptions());
        }

        // SELENIDE needs this driver.
        WebDriverRunner.setWebDriver(driver);
    }


    /**
     * Remote selenium server (nodes) needs to have new instance for every test (not singleton).
     * Otherwise on the driver.quit() lose the session.
     * @return
     * @throws MalformedURLException
     */
    private URL getRemoteUrl() throws MalformedURLException
    {
        //return new URL( HUB_URL );
        return new URL( BROWSERSTACK_HUB_URL );
    }


    private ChromeOptions getChromeOptions()
    {
        ChromeOptions options = new ChromeOptions();

        //options.addArguments("headless");
        //options.addArguments("window-size=1400,800");
        //options.addArguments("disable-gpu");

        return options;
    }


    /**
     * browserstack.com is third party Selenium server hub
     * @return
     */
    public static DesiredCapabilities getBrowserstackChromeOptions()
    {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "88.0");
        caps.setCapability("name", "Cucumber Tatrytec Browserstack test");

        return caps;
    }


    /**
     * browserstack.com is third party Selenium server hub
     * TODO Does not work with Selenide from the box. May be some extension???
     * @return
     */
    public static DesiredCapabilities getBrowserstackAndroidOptions()
    {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("browserName", "android");
        caps.setCapability("device", "Samsung Samsung Galaxy A51");
        caps.setCapability("realMobile", "true");
        caps.setCapability("os_version", "10.0");
        caps.setCapability("name", "Cucumber Tatrytec Browserstack test");
        caps.setCapability("build", "Build Cucumber Tatrytec"); // CI/CD job or build name

        return caps;
    }


    /**
     * browserstack.com is third party Selenium server hub
     * TODO Does not work with Selenide from the box. May be some extension???
     * @return
     */
    public static DesiredCapabilities getBrowserstackIPhoneOptions()
    {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("browser", "iPhone");
        caps.setCapability("device", "iPhone 12");
        caps.setCapability("realMobile", "true");
        caps.setCapability("os_version", "14");
        caps.setCapability("name", "Cucumber Tatrytec Browserstack test");
        caps.setCapability("build", "Build Cucumber Tatrytec"); // CI/CD job or build name

        return caps;
    }


    /**
     * browserstack.com is third party Selenium server hub
     * @return
     */
    public static DesiredCapabilities getBrowserstackEdgeOptions()
    {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Edge");
        caps.setCapability("browser_version", "89.0");
        caps.setCapability("name", "Cucumber Tatrytec Browserstack test");
        caps.setCapability("build", "Build Cucumber Tatrytec"); // CI/CD job or build name

        return caps;
    }
}

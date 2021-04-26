
package services;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.typesafe.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;


public class WebDriverService
{

    protected static Config conf = ConfigSingletonService.conf();  // resources/application.conf

    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";

    public static final String HUB_URL = "http://127.0.0.1:4444";

    // browserstack.com is third party Selenium server hub
    public static final String BROWSERSTACK_HUB_URL = "https://vladimramaj1:LfPypf1dhvxbSNQsfV1X@hub-cloud.browserstack.com/wd/hub";


    /**
     * If does not use native Selenide driver we has to set it up in WebDriverRunner.setWebDriver(driver);
     */
    public static void setDriver() throws MalformedURLException
    {
        String browser = System.getProperty("browser");
        browser = browser == null || browser.equals("") ? CHROME : browser.toLowerCase();

        System.setProperty("webdriver.gecko.driver", "/home/tatrytec/custom-scripts/selenium-server/geckodriver");
        //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette",true);
        options.setHeadless(conf.getBoolean("env.production"));
        options.addArguments("--version");

        Configuration.remote = HUB_URL;
        //Configuration.browser = browser;
        //Configuration.headless = conf.getBoolean("env.production");
        URL hub = new URL(HUB_URL);
        WebDriver driver = new RemoteWebDriver(hub, options);
        WebDriverRunner.setWebDriver(driver);

        //DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setBrowserName(browser);
    }


    public static void closeBrowser()
    {
        WebDriver driver = WebDriverRunner.getWebDriver();
        driver.close();
        if( !Configuration.browser.equals(FIREFOX) ) driver.quit();
    }


    public static DesiredCapabilities getDesiredCapabilities()
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        caps.setCapability("browser", "firefox");

        return caps;
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

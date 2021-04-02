
package services;


import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;


public class WebDriverService
{

    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";

    public static final String HUB_URL = "http://127.0.0.1:4444/wd/hub";


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
        return new URL( HUB_URL );
    }


    private ChromeOptions getChromeOptions()
    {
        ChromeOptions options = new ChromeOptions();

        //options.addArguments("headless");
        //options.addArguments("window-size=1400,800");
        //options.addArguments("disable-gpu");

        return options;
    }
}

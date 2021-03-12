
package steps;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import com.typesafe.config.Config;
import org.junit.Rule;
import pages.BasePage;
import pages.admin.AdminPage;
import services.ConfigSingletonService;

import static com.codeborne.selenide.Selenide.open;


public class BaseAdminSteps extends BaseSteps
{

    public AdminPage adminPage;


    public BaseAdminSteps()
    {
        openPage(OPEN_URL);

        adminPage = new AdminPage();

        adminPage.login(conf.getString("login.email"), conf.getString("login.password"));

        adminPage.openAdmin();
    }

}

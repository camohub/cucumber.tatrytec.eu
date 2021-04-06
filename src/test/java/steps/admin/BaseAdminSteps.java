
package steps.admin;


import pages.HomepagePage;
import pages.admin.AdminPage;
import services.PageSingletonService;
import steps.BaseSteps;


public class BaseAdminSteps extends BaseSteps
{

    public AdminPage adminPage;


    public BaseAdminSteps()
    {
        adminPage = PageSingletonService.getAdminPage();
    }

}

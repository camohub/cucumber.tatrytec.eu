
package steps;


import pages.admin.AdminPage;


public class BaseAdminSteps extends BaseSteps
{

    public AdminPage adminPage;


    public BaseAdminSteps()
    {
        adminPage = new AdminPage();
        login();
        adminPage.clickOnAdminLink();
    }

}

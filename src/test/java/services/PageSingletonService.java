
package services;


import pages.HomepagePage;
import pages.admin.AdminPage;
import pages.admin.CreateEditArticlePage;
import pages.admin.CreateEditCategoryPage;


public class PageSingletonService
{

    public static HomepagePage homepagePage;

    public static AdminPage adminPage;

    public static CreateEditArticlePage createEditArticlePage;

    public static CreateEditCategoryPage createEditCategoryPage;


    /**
     * Returns page singleton
     * @return
     */
    public static HomepagePage getHomePage()
    {
        if( homepagePage == null ) homepagePage = new HomepagePage();

        return homepagePage;
    }

    public static AdminPage getAdminPage()
    {
        if( adminPage == null ) adminPage = new AdminPage();

        return adminPage;
    }

    public static CreateEditArticlePage getCreateEditArticlePage()
    {
        if( createEditArticlePage == null ) createEditArticlePage = new CreateEditArticlePage();

        return createEditArticlePage;
    }

    public static CreateEditCategoryPage getCreateEditCategoryPage()
    {
        if( createEditCategoryPage == null ) createEditCategoryPage = new CreateEditCategoryPage();

        return createEditCategoryPage;
    }

}

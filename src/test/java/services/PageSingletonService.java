
package services;


import pages.*;
import pages.admin.*;


public class PageSingletonService
{

    public static HomepagePage homepagePage;

    public static ArticlePage articlePage;

    public static AdminPage adminPage;

    public static CreateEditArticlePage createEditArticlePage;

    public static CreateEditCategoryPage createEditCategoryPage;

    public static ArticlesFilterTablePage articlesFilterTablePage;

    public static ArticleCommentsPage adminArticleCommentsPage;

    public static GoogleLoginPage googleLoginPage;

    public static GithubLoginPage githubLoginPage;

    public static FacebookLoginPage facebookLoginPage;


    /**
     * Returns page singleton
     * @return
     */
    public static HomepagePage getHomePage()
    {
        if( homepagePage == null ) homepagePage = new HomepagePage();
        return homepagePage;
    }

    public static ArticlePage getArticlePage()
    {
        if( articlePage == null ) articlePage = new ArticlePage();
        return articlePage;
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

    public static ArticlesFilterTablePage getArticlesFilterTablePage()
    {
        if( articlesFilterTablePage == null ) articlesFilterTablePage = new ArticlesFilterTablePage();
        return articlesFilterTablePage;
    }

    public static ArticleCommentsPage getAdminArticleCommentsPage()
    {
        if( adminArticleCommentsPage == null ) adminArticleCommentsPage = new ArticleCommentsPage();
        return adminArticleCommentsPage;
    }

    public static GoogleLoginPage getGoogleLoginPage()
    {
        if( googleLoginPage == null ) googleLoginPage = new GoogleLoginPage();
        return googleLoginPage;
    }

    public static GithubLoginPage getGithubLoginPage()
    {
        if( githubLoginPage == null ) githubLoginPage = new GithubLoginPage();
        return githubLoginPage;
    }

    public static FacebookLoginPage getFacebookLoginPage()
    {
        if( facebookLoginPage == null ) facebookLoginPage = new FacebookLoginPage();
        return facebookLoginPage;
    }

}

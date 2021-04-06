package pages.admin;


import com.codeborne.selenide.Condition;
import pages.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.*;


public class AdminPage extends BasePage
{

    /**
     * Constructor
     */
    public AdminPage()
    {

    }


    public void openCreateArticlePage()
    {
        $("#main")
            .find(byAttribute("href", "https://tatrytec.eu/admin/articles/create"))
            .shouldBe(visible, ofSeconds(14)).click();
    }


    public void openEditArticlesPage()
    {
        $("#main")
            .find(byAttribute("href", "https://tatrytec.eu/admin/articles"))
            .shouldBe(visible, ofSeconds(14)).click();
    }
}

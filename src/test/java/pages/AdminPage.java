package pages;


import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class AdminPage extends BasePage
{

    public AdminPage()
    {

    }


    public void checkSuccessLogin()
    {
        $("#alerts-wrapper .alert-success").shouldHave( text("Vitajte na palube") );
    }


    public void clickOnAdminLink()
    {
        $("#sideMenu").find(byAttribute("href", "https://tatrytec.eu/admin")).click();
    }


    public void checkAdminPage()
    {
        $("#main").find(byAttribute("href", "https://tatrytec.eu/admin/articles/create"));
    }
}

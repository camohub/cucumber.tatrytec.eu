package pages;


import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.*;


public class AdminPage extends BasePage
{

    public AdminPage()
    {

    }


    public void clickOnAdminLink()
    {
        $("#sideMenu").find(byAttribute("href", "https://tatrytec.eu/admin"))
                .shouldBe(visible, ofSeconds(7)).click();
    }


    public void checkAdminPage()
    {
        $("#main").find(byAttribute("href", "https://tatrytec.eu/admin/articles/create"))
                .shouldBe(visible, ofSeconds(7));
    }
}

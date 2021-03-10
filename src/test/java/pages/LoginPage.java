
package pages;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.*;


public class LoginPage extends BasePage
{

    public LoginPage()
    {
        open("");
        page(this);
    }


    public void openLoginModal()
    {
        $("#sideMenu").find(byAttribute("data-target", "#loginModal")).click();
        SelenideElement modal = $("#loginModal").should(appear);
    }


    public void fillEmail(String email)
    {
        $("#loginModal").find( byName("email") ).val(email);
    }


    public void fillPassword(String password)
    {
        $("#loginModal").find( byName("password") ).val(password);
    }


    public void sendForm()
    {
        $("#loginModal").find( byAttribute("type", "submit") ).click();
    }


    public void checkLoginResponse(String cssSelector, String text)
    {
        // Is new element do not use prev one.
        $(cssSelector).shouldBe(visible, ofSeconds(7))
                .shouldHave( text(text) );
    }
}

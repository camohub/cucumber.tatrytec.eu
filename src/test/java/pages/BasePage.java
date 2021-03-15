
package pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;


public class BasePage
{

    public BasePage()
    {

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    /// Base messages used across the pages ////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////

    public void checkSuccessMessage(String text)
    {
        $("#alerts-wrapper").find(".alert-success").shouldHave(text(text), ofSeconds(14));
    }

    public void checkErrorMsg(String text)
    {
        $("#main").find(".alert-danger").shouldHave(text(text), ofSeconds(14));
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    ///// Used for base login e.g. for admin ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////

    public void login(String email, String password)
    {
        $("#sideMenu")
                .shouldBe(visible, ofSeconds(14))
                .find(byAttribute("data-target", "#loginModal")).click();

        SelenideElement modal = $("#loginModal");
        modal.find( byName("email") ).val(email);
        modal.find( byName("password") ).val(password);
        modal.find( byAttribute("type", "submit") ).click();
    }

    public void openAdmin()
    {
        $("#sideMenu").find(byAttribute("href", "https://tatrytec.eu/admin"))
                .shouldBe(visible, ofSeconds(14)).click();
    }

}

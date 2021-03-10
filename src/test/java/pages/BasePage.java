
package pages;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;


public class BasePage
{

    public BasePage()
    {

    }


    public void login(String email, String password)
    {
        $("#sideMenu").find(byAttribute("data-target", "#loginModal")).click();

        SelenideElement modal = $("#loginModal");
        modal.find( byName("email") ).val(email);
        modal.find( byName("password") ).val(password);
        modal.find( byAttribute("type", "submit") ).click();
    }

}

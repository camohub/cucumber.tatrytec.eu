
package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Dimension;

import java.util.HashMap;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;


public class BasePage
{

    /**
     * Constructor
     */
    public BasePage()
    {

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    /// BASE MESSAGE USED ACROSS THE PAGES /////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////

    public void checkSuccess()
    {
        $("#alerts-wrapper").find(".alert-success").shouldBe(visible, ofSeconds(14));
    }

    public void checkSuccessMessage(String text)
    {
        $("#alerts-wrapper").find(".alert-success").shouldHave(text(text), ofSeconds(14));
    }

    public void checkError()
    {
        $(".alert-danger").shouldBe(visible, ofSeconds(14));
    }

    public void checkErrorMessage(String text)
    {
        $(".alert-danger").shouldHave(text(text), ofSeconds(14));
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    /// USED FOR BASE LOGIN E.G. FOR ADMIN /////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////

    public void login(String email, String password)
    {
        $("#sideMenu").find(byAttribute("data-target", "#loginModal"))
                .shouldBe(visible, ofSeconds(14)).click();

        SelenideElement modal = $("#loginModal");
        modal.find( byName("email") ).val(email);
        modal.find( byName("password") ).val(password);
        modal.find( byAttribute("type", "submit") ).click();
    }

    public void clickOnAdminLink()
    {
        $("#sideMenu").find(byAttribute("href", "https://tatrytec.eu/admin"))
                .shouldBe(visible, ofSeconds(14)).click();
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    /// HELPERS ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////

    protected HashMap<String, Integer> getElementTopLeftOffset(SelenideElement el)
    {
        HashMap<String, Integer> result = new HashMap<>();
        Dimension size = el.getSize();

        int elTopLeftXOffset = (size.getWidth()/2) - size.getWidth();
        int elTopLeftYOffset = (size.getHeight()/2) - size.getHeight();

        result.put("x", elTopLeftXOffset);
        result.put("y", elTopLeftYOffset);

        return result;
    }

    protected HashMap<String, Integer> getElementBottomRightOffset(SelenideElement el)
    {
        HashMap<String, Integer> result = new HashMap<>();
        Dimension size = el.getSize();

        int elBottomLeftXOffset = (size.getWidth()/2);
        int elBottomLeftYOffset = (size.getHeight()/2);

        result.put("x", elBottomLeftXOffset);
        result.put("y", elBottomLeftYOffset);

        return result;
    }

}

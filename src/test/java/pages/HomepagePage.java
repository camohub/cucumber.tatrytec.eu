
package pages;


import com.codeborne.selenide.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;


public class HomepagePage extends BasePage
{

    public void openArticleDetail()
    {
        $("#main").find("h1 a").shouldBe(visible, ofSeconds(14)).click();
    }


    public void testHeader()
    {
        SelenideElement header = $("#header").shouldHave( exactText("xxxTatrytec.eu"), ofSeconds(14));
    }


    public void testArticles()
    {
        ElementsCollection articles = $$("#main h1 a").shouldBe( size(7) );
    }


    public void testMenu()
    {
        ElementsCollection sideMenu = $$("#sideMenu li")
                .shouldBe( sizeGreaterThan(4) )
                .shouldHave( itemWithText("Najnovšie") )
                .shouldHave( itemWithText("Prihlásiť") )
                .shouldHave( itemWithText("Registrovať") );
    }


    public void testPagination()
    {
        ElementsCollection pagination = $$("ul.pagination li")
                .shouldBe( sizeGreaterThan(2) );
        pagination.get(1).shouldHave( cssClass("active") );
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////
    /// LOGIN FEATURES /////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    public void openLoginModal()
    {
        $("#sideMenu").find(byAttribute("data-target", "#loginModal"))
                .shouldBe(visible, ofSeconds(14)).click();
        $("#loginModal").shouldBe(visible);
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
        $(cssSelector).shouldBe(visible, ofSeconds(30))
                .shouldHave( text(text) );
    }

}

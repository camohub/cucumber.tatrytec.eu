package pages.admin;


import com.codeborne.selenide.SelenideElement;
import pages.BasePage;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;


public class CreateEditCategoryPage extends BasePage
{


    public void openEditCategoriesPage()
    {
        $("#main")
                .find(byAttribute("href", "https://tatrytec.eu/admin/categories"))
                .shouldBe(visible, ofSeconds(7)).click();
    }


    public void openCreateCategoryForm()
    {
        $("#main")
                .find(byAttribute("data-target", "#editCategoryFormModal"))
                .shouldBe(visible, ofSeconds(7)).click();

        $("#editCategoryFormModal").should(appear);
    }


    public void clickOnEditCategoryIcon(String text)
    {
        $("#main").find(byAttribute("data-name", text))
                .shouldBe(visible, ofSeconds(14)).click();

        $("#editCategoryFormModal").should(appear);
    }

    ////////////////////////////////////////////////////////////////////////////////////
    /// FILL //////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////

    public void fillName(String text)
    {
        $(byName("name")).val(text);
    }


    public void fillParentCategory(String cat)
    {
        $(byName("categories[]")).find(byAttribute("value", cat)).click();
    }


    public void sendForm()
    {
        $(byAttribute("type", "submit")).click();
    }

    //////////////////////////////////////////////////////////////////////////
    /// CHECK ///////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////

    public void checkCategoryExists(String text)
    {
        $("#sortableCategoriesWrapper").find("li").shouldHave(text(text), ofSeconds(14));
    }


    public void checkCategoryVisibility(Boolean shouldBeVisible)
    {
        SelenideElement li = $("#sortableCategoriesWrapper").find("li");

        if( shouldBeVisible ) li.find(".fa-check-circle").shouldBe(visible, ofSeconds(14));
        else li.find(".fa-minus-circle").shouldBe(visible, ofSeconds(14));
    }


    public void checkExpectedCategoryName(String text)
    {
        $(byName("name")).shouldHave(value(text));
    }


    public void checkParentCategoryExists(String text)
    {
        $(byName("parent_id")).find(":selected").shouldHave(text(text));
    }

}

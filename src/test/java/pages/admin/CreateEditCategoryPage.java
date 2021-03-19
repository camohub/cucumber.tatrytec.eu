package pages.admin;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;


public class CreateEditCategoryPage extends BasePage
{


    public void openEditCategoriesPage()
    {
        $("#main")
                .find(byAttribute("href", "https://tatrytec.eu/admin/categories"))
                .shouldBe(visible, ofSeconds(30)).click();
    }


    public void openCreateCategoryForm()
    {
        $("#main")
                .find(byAttribute("data-target", "#editCategoryFormModal"))
                .shouldBe(visible, ofSeconds(14)).click();

        $("#editCategoryFormModal").should(appear);
    }


    public void clickOnEditCategoryIcon(String text)
    {
        $("#main").find(byAttribute("data-name", text))
                .shouldBe(visible, ofSeconds(14)).click();

        $("#editCategoryFormModal").should(appear);
    }


    public void clickOnListOpenIcon(String text)
    {
        $$("#main .sortable li").find(text(text)).find(".fa-plus").click();
    }


    public void saveCategoriesOrder()
    {
        $("a.editSort").click();
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    /// DRAGGING //////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Current state is subCategory inside the parentCategory
     * Expected state is subCategory is outside and above the parentCategory
     */
    public void dragSubcategoryOutOfParentCategory(String parentCategoryText)
    {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());

        SelenideElement parentCategory = $$("#main .sortable li").find(text(parentCategoryText));
        SelenideElement childCategory = parentCategory.find("ul li");

        HashMap<String, Integer> parentTopLeftOffset = getElementTopLeftOffset(parentCategory);
        Integer parentX = parentTopLeftOffset.get("x");
        Integer parentY = parentTopLeftOffset.get("y");


        actions.moveToElement(childCategory).perform();
        actions.clickAndHold().perform();
        actions.moveToElement(parentCategory, parentX + 4, parentY + 4).perform();  // +4 cause we want to be little inside not on the edge.
        // Needs to simulate mousemove over the parent element,
        // otherwise it does not open new hint holder.
        sleep(100);
        actions.moveToElement(parentCategory, parentX + 3, parentY + 3).perform();
        sleep(100);
        actions.moveToElement(parentCategory, parentX + 2, parentY + 2).perform();
        sleep(1000);
        actions.release().build().perform();
    }

    /**
     * Current state is subCategory is outside and above the parentCategory
     * Expected state is subCategory is back inside the parentCategory
     */
    public void dragSubCategoryInsideTheParentCategory(String parentText, String childText)
    {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());

        ElementsCollection categories = $$("#main .sortable li");
        SelenideElement parentCategory = categories.find(text(parentText));
        SelenideElement childCategory = categories.find(text(childText));

        HashMap<String, Integer> parentBottomRightOffset = getElementBottomRightOffset(parentCategory);
        Integer parentX = parentBottomRightOffset.get("x");
        Integer parentY = parentBottomRightOffset.get("y");


        actions.moveToElement(childCategory).perform();
        actions.clickAndHold().perform();
        actions.moveToElement(parentCategory, parentX - 5, parentY - 5).perform();  // -5 cause we want to be little inside not on the edge.
        // Needs to simulate mousemove over the parent element,
        // otherwise it does not open new hint holder.
        sleep(100);
        actions.moveToElement(parentCategory, parentX - 4, parentY - 4).perform();
        sleep(100);
        actions.moveToElement(parentCategory, parentX - 3, parentY - 3).perform();
        sleep(1000);
        actions.release().build().perform();
    }

    ////////////////////////////////////////////////////////////////////////////////////
    /// FILL //////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////

    public void fillName(String text)
    {
        $(byName("name")).val(text);
    }


    public void fillParentCategory(String text)
    {
        $(byName("parent_id")).find(byText(text)).click();
    }


    public void sendForm()
    {
        $(byAttribute("type", "submit")).click();
    }

    ////////////////////////////////////////////////////////////////////////////////
    /// CHECK /////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////

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


    public void checkIfSubcategoryIsAboveTheParentCategory(String parentText, String childText)
    {
        ElementsCollection lis = $$("#main .sortable li");

        Integer parentIndex = null;
        Integer childIndex = null;

        for (int i = 0; i < lis.size(); i++) {
            if( lis.get(i).getText().equals(parentText) ) parentIndex = i;
            if( lis.get(i).getText().equals(childText) ) childIndex = i;
        }

        Assert.assertTrue("Subcategory should be above the parent category.", childIndex < parentIndex);
    }


    public void checkIfSubcategoryIsInsideTheParentCategory(String parentText, String childText)
    {
        SelenideElement parentCategory = $$("#main .sortable li").find(text(parentText));
        parentCategory.find(".fa-plus").click();
        parentCategory.find("ul li").shouldHave(text(childText));
    }

}

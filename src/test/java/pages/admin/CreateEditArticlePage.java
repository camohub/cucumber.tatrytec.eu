package pages.admin;


import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;


public class CreateEditArticlePage extends BasePage
{


    public void openCreateArticlePage()
    {
        $("#main")
                .find(byAttribute("href", "https://tatrytec.eu/admin/articles/create"))
                .shouldBe(visible, ofSeconds(7)).click();
    }


    public void openEditArticlesPage()
    {
        $("#main")
                .find(byAttribute("href", "https://tatrytec.eu/admin/articles"))
                .shouldBe(visible, ofSeconds(7)).click();
    }


    public void clickOnEditArticleIcon(String text)
    {
        $("#main")
                .find("tr:nth-child(2)").shouldHave(text(text), ofSeconds(14))
                .find(byAttribute("title", "Edit")).click();
    }

    ////////////////////////////////////////////////////////////////////////////////////
    /// FILL //////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////

    public void fillMetaDesc(String text)
    {
        $(byName("meta_desc")).val(text);
    }


    public void fillTitle(String text)
    {
        $(byName("title")).val(text);
    }


    public void fillPerex(String text)
    {
        $("#perex_ifr").click();
        WebDriver driver = WebDriverRunner.getWebDriver();
        ((JavascriptExecutor)driver).executeScript("tinyMCE.activeEditor.setContent('" + text + "')");
    }


    public void fillText(String text)
    {
        $("#content_ifr").click();
        WebDriver driver = WebDriverRunner.getWebDriver();
        ((JavascriptExecutor)driver).executeScript("tinyMCE.activeEditor.setContent('" + text + "')");
    }


    public void fillCategories(String cat1, String cat2)
    {
        $(byName("categories[]")).find(byAttribute("value", cat1)).click();
        $(byName("categories[]")).find(byAttribute("value", cat2)).click();
    }


    public void sendForm()
    {
        $(byAttribute("type", "submit")).click();
    }


    //////////////////////////////////////////////////////////////////////////
    /// CHECK ///////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////


    public void checkSuccessMessage()
    {
        $("#alerts-wrapper").find(".alert-success").shouldHave(text("Článok bol uložený"), ofSeconds(14));
    }


    public void checkArticleExists(String text)
    {
        $("#main tr:nth-child(2)").find("td:nth-child(1)").shouldHave(text(text), ofSeconds(14));
    }

    public void checkErrorMsg(String text)
    {
        $("#main").find(".alert-danger").shouldHave(text(text), ofSeconds(14));
    }
}

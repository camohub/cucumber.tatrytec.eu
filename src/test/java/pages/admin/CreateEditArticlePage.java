package pages.admin;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static java.time.Duration.ofSeconds;


public class CreateEditArticlePage extends BasePage
{

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// FILL //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
        $("#perex_ifr").shouldBe(visible, ofSeconds(60)).click();  // 60 because TinyMCE sometimes take a log time.
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


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// CHECK /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void checkArticleMetaDesc(String text)
    {
        $(byName("meta_desc")).shouldHave(value(text));
    }


    public void checkArticleTitle(String text)
    {
        $(byName("title")).shouldHave(value(text));
    }


    public void checkArticlePerex(String text)
    {
        $("#perex_ifr").click();
        JavascriptExecutor js = (JavascriptExecutor)WebDriverRunner.getWebDriver();
        String content = String.valueOf(js.executeScript("return tinyMCE.activeEditor.getContent()"));
        Assert.assertEquals(text, content);
    }


    public void checkArticleText(String text)
    {
        $("#content_ifr").click();
        JavascriptExecutor js = (JavascriptExecutor)WebDriverRunner.getWebDriver();
        String content = String.valueOf(js.executeScript("return tinyMCE.activeEditor.getContent()"));
        Assert.assertEquals(text, content);
    }


    public void checkArticleCategories(String cat1, String cat2)
    {
        ElementsCollection options = $(byName("categories[]")).findAll(":selected");

        options.find(value(cat1)).shouldHave(value(cat1), ofSeconds(14));
        options.find(value(cat2)).shouldHave(value(cat2), ofSeconds(14));
    }
}

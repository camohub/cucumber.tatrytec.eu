package pages.admin;


import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;


public class CreateArticlePage extends BasePage
{


    public void openCreateArticlePage()
    {
        $("#main")
                .find(byAttribute("href", "https://tatrytec.eu/admin/articles/create"))
                .shouldBe(visible, ofSeconds(7)).click();
    }


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


    public void fillCategories()
    {
        $(byName("categories[]")).find(byAttribute("value", "122")).click();
        $(byName("categories[]")).find(byAttribute("value", "100")).click();
    }


    public void sendForm()
    {
        $(byAttribute("type", "submit")).click();
    }


    public void checkSuccessMessage()
    {
        $("#alerts-wrapper").find(".alert-success").shouldHave(text("Článok bol uložený"), ofSeconds(14));
    }


    public void checkArticleExists(String text)
    {
        $("#main tr:nth-child(2)").find("td:nth-child(1)").shouldHave(text(text), ofSeconds(14));
    }
}

package pages.admin;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.BasePage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;


public class ArticlesFilterTablePage extends BasePage
{

    private SelenideElement testedRow;
    private String testedRowTitle;
    private String testedRowUser;


    //////////////////////////////////////////////////////////////////////////////////////////
    /// Click ///////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////

    public void clickOnEditArticleIcon(String text)
    {
        SelenideElement icon = $("#main")
                .find("tr:nth-child(2)").shouldHave(text(text), ofSeconds(14))
                .find(byAttribute("title", "Edit"));
        sleep(1000);  // Because javascript sometimes is not prepared yet.
        icon.click();
    }

    public void clickOnArticleCommentsIcon()
    {
        SelenideElement tr = $$("#main table tr a")
                .findBy(text(commentArticleTitle))
                .shouldBe(visible, ofSeconds(14));

        tr.find("a.fa-commenting-o").shouldBe(visible, ofSeconds(14)).click();
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    /// Fill //////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////

    public void selectUser(String userName)
    {
        $(byName("users[]")).find(byText(userName)).click();
    }


    public void fillTitleFromTable()
    {
        setTestedRow();
        $(byName("title")).val(testedRowTitle);
    }


    public void selectOrderByDateAsc()
    {
        $(byName("sort")).find(byValue("created_at ASC")).click();
    }


    public void selectOrderByDateDesc()
    {
        $(byName("sort")).find(byValue("created_at DESC")).click();
    }


    public void sendForm()
    {
        $(byAttribute("type", "submit")).click();
    }


    ////////////////////////////////////////////////////////////////////////////////////////
    /// CHECK /////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////

    public void checkArticleExists(String text)
    {
        $("#main tr:nth-child(2)").find("td:nth-child(1)").shouldHave(text(text), ofSeconds(14));
    }


    public void checkFilteredUser(String userName)
    {
        ElementsCollection trs = $$("#main tr");
        int size = trs.size();

        for (int i = 0; i < size; i++) {
            if(i == 0) continue;  // First row - headers
            String tdUserName = trs.get(i).find(byXpath("td[2]")).text();
            Assert.assertEquals(userName, tdUserName);
        }
    }


    public void checkFilteredTitle()
    {
        $$("#main table tr").get(1).findAll("td").get(0).shouldHave(text(testedRowTitle));
    }


    public void checkFilteredDateAsc() throws ParseException
    {
        Date prevDate = null;
        ElementsCollection trs = $$("#main tr");
        int size = trs.size();

        for (int i = 1; i < size; i++)  // Starts at index 1 to skip first tr
        {
            String dateString = trs.get(i).findAll("td").get(2).text();
            Date date = getDateFromString("dd.MM. yyyy", dateString);

            if (prevDate == null) prevDate = date;

            if( prevDate.after(date) ) Assert.fail("Date " + date + " must not be after date " + prevDate);

            prevDate = date;
        }
    }


    public void checkFilteredDateDesc() throws ParseException
    {
        Date prevDate = null;
        ElementsCollection trs = $$("#main tr");
        int size = trs.size();

        for (int i = 1; i < size; i++)  // Starts at index 1 to skip first tr
        {
            String dateString = trs.get(i).findAll("td").get(2).text();
            Date date = getDateFromString("dd.MM. yyyy", dateString);

            if (prevDate == null) prevDate = date;

            if( prevDate.before(date) ) Assert.fail("Date " + date + " must not be after date " + prevDate);

            prevDate = date;
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////
    /// HELPERS ///////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////

    public void setTestedRow()
    {
        if( testedRow == null )
        {
            testedRow = $$("#main table tr").get(7);
            ElementsCollection tds = testedRow.findAll("td");
            testedRowTitle = tds.get(0).text();
            testedRowUser = tds.get(1).text();
        }
    }


    public Date getDateFromString(String format, String dateString) throws ParseException
    {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(dateString);
    }
}

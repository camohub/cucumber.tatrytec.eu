package pages.admin;


import com.codeborne.selenide.Selenide;
import pages.BasePage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;


public class ArticleCommentsPage extends BasePage
{


    //////////////////////////////////////////////////////////////////////////////////////////
    /// Click ///////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////

    public void clickOnDeleteIcon(String comment)
    {
        $$("#main div")
            .findBy(text(comment)).parent()
            .find(".fa-check-circle")
            .shouldBe(visible, ofSeconds(14))
            .click();
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    /// CHECK /////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////

    public void checkInvisibleCommentStatus(String comment)
    {
        Selenide.refresh();

        $$("#main div")
            .findBy(text(comment)).parent()
            .find(".fa-minus-circle")
            .shouldBe(visible, ofSeconds(14));
    }

}

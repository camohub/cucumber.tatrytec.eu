
package pages;


import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;


public class ArticlePage extends BasePage
{

    public void writeComment(String comment)
    {
        SelenideElement textArea = $("#commentText").shouldBe(visible, ofSeconds(14));
        textArea.val(comment);
    }

    public void saveComment()
    {
        $("#addCommnent").shouldBe(visible, ofSeconds(14)).click();
    }

    public void checkCommentExists(String comment)
    {
        $$(".comment-item").findBy(text(comment)).shouldBe(visible, ofSeconds(14));
        commentArticleTitle = $("#main h1").text();  // Next feature will find this title and check comment delete.
        System.out.println(commentArticleTitle);
    }


    public void clickOnGithubLoginBtn()
    {
        //fakeMouseActions();
        SelenideElement button = $("#githubLogin").shouldBe(visible, ofSeconds(14));
        button.scrollTo().click();
    }

    public void clickOnFacebookLoginBtn()
    {
        //fakeMouseActions();
        SelenideElement button = $("#fbLogin").shouldBe(visible, ofSeconds(14));
        button.scrollTo().click();
    }

    public void clickOnGoogleLoginBtn()
    {
        //fakeMouseActions();
        SelenideElement button = $("#gLogin").shouldBe(visible, ofSeconds(14));
        button.scrollTo().click();
    }

}

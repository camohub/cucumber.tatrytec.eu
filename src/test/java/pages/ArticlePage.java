
package pages;


import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.sleep;
import static java.time.Duration.ofSeconds;
import static com.codeborne.selenide.Selenide.$;


public class ArticlePage extends BasePage
{

    public void clickOnGithubLoginBtn()
    {
        //fakeMouseActions();
        SelenideElement button = $("#githubLogin").shouldBe(visible, ofSeconds(14));
        button.scrollTo().click();
    }

    public void clickOnFacebookLoginBtn()
    {
        //fakeMouseActions();
        SelenideElement button = $("#facebookLogin").shouldBe(visible, ofSeconds(14));
        button.scrollTo().click();
    }

    public void clickOnGoogleLoginBtn()
    {
        //fakeMouseActions();
        SelenideElement button = $("#gLogin").shouldBe(visible, ofSeconds(14));
        button.scrollTo().click();
    }

}


package pages;


import static com.codeborne.selenide.Condition.visible;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;


public class GithubLoginPage extends BasePage
{

    public void fillAndSendForm(String email, String pass)
    {
        sleep(5000);
        $(By.name("login")).shouldBe(visible, ofSeconds(14)).val(email);
        sleep(5000);
        $(By.name("password")).shouldBe(visible, ofSeconds(7)).val(pass);
        sleep(5000);
        $(By.name("commit")).shouldBe(visible, ofSeconds(7)).click();
    }

}


package pages;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;
import org.openqa.selenium.By;


public class FacebookLoginPage extends BasePage
{

    public void fillAndSendForm(String email, String pass)
    {
        sleep(5000);
        $(By.name("email")).shouldBe(visible, ofSeconds(14)).val(email);
        sleep(5000);
        $(By.name("pass")).shouldBe(visible, ofSeconds(7)).val(pass);
        sleep(5000);
        $(By.name("login")).shouldBe(visible, ofSeconds(7)).click();
    }

}

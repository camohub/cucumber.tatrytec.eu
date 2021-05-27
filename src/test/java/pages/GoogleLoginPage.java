
package pages;


import static com.codeborne.selenide.Condition.visible;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;


public class GoogleLoginPage extends BasePage
{

    public void selectAccount()
    {
        $(".d2laFc").shouldBe(visible, ofSeconds(7)).click();
    }

    public void fillEmail(String email)
    {
        $(By.name("identifier")).shouldBe(visible, ofSeconds(7)).val(email);
        sleep(5000);
        $("button.VfPpkd-LgbsSe-OWXEXe-dgl2Hf").click();
    }

    public void fillPassword(String pass)
    {
        sleep(5000);
        $(By.name("password")).shouldBe(visible, ofSeconds(7)).val(pass);
        sleep(5000);
        $("button").click();
    }

}

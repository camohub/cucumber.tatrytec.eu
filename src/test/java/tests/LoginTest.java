package tests;


import categories.FastTest;
import categories.FullTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import java.util.Arrays;
import java.util.List;


@Category({FastTest.class, FullTest.class})
@RunWith(Parameterized.class)
public class LoginTest extends BaseTest
{

    String email;
    String passwrod;
    String cssSelector;
    String message;


    public LoginTest(String email, String password, String cssSelector, String message)
    {
        this.email = email;
        this.passwrod = password;
        this.cssSelector = cssSelector;
        this.message = message;
    }



    @Test
    public void login() throws InterruptedException
    {
        LoginPage loginPage = new LoginPage();

        loginPage.fillEmail(email);
        loginPage.fillPassword(passwrod);
        loginPage.sendForm();
        loginPage.checkLoginResponse(cssSelector, message);
    }


    @Parameterized.Parameters
    public static List<Object[]> loginData()
    {
        return Arrays.asList(new Object[][] {
            /* email    password    cssSelector    message */
            {"","", "#loginModal .alert-danger", "Nesprávny email, alebo heslo."},
            {"aaaaaaa", "aaaaaaaaaa", "#loginModal .alert-danger", "Nesprávny email, alebo heslo."},
            {"aaaaaaa@aaaaa.aa", "aaaaaaaaaa", "#loginModal .alert-danger", "Nesprávny email, alebo heslo."},
            {"vladimircamaj@gmail.com", "vladimir", "#alerts-wrapper .alert-success", "Vitajte na palube"},
        });
    }
}
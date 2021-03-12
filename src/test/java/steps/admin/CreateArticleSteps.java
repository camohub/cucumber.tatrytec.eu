package steps.admin;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.admin.AdminPage;
import pages.admin.CreateArticlePage;
import steps.BaseAdminSteps;
import steps.BaseSteps;

import java.security.SecureRandom;


public class CreateArticleSteps extends BaseAdminSteps
{

    CreateArticlePage createArticlePage;

    String testText = "Test text";


    public CreateArticleSteps()
    {
        createArticlePage = new CreateArticlePage();
    }


    @When("Click on new article link")
    public void clickOnNewArticleLink()
    {
        createArticlePage.openCreateArticlePage();
    }

    @And("Fill meta description")
    public void fillMetaDescription()
    {
        createArticlePage.fillMetaDesc(testText);
    }

    @And("Fill title")
    public void fillTitle()
    {
        createArticlePage.fillTitle(testText);
    }

    @And("perex")
    public void perex()
    {
        createArticlePage.fillPerex("<h2>" + testText + "</h2>");
    }

    @And("Fill text")
    public void fillText()
    {
        createArticlePage.fillText("<h2>" + testText + "</h2>");
    }

    @And("Fill categories")
    public void fillCategories()
    {
        createArticlePage.fillCategories();
    }

    @And("Send form")
    public void sendForm()
    {
        createArticlePage.sendForm();
    }

    @Then("Check success message")
    public void checkSuccessMessage()
    {
        createArticlePage.checkSuccessMessage();
    }

    @And("Check article exists")
    public void checkArticleExists()
    {
        createArticlePage.checkArticleExists(testText);
    }
}

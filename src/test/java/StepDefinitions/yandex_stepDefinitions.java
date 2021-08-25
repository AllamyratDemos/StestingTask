package StepDefinitions;

import Pages.Yandex;
import Utilities.BaseMethods;
import Utilities.ConfigurationReader;
import Utilities.waits;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class yandex_stepDefinitions extends Yandex {
    BaseMethods baseMethods=new BaseMethods();
    @Given("user is on {string}")
    public void user_is_on(String url) {
        url= ConfigurationReader.get("yandexUrl");
        baseMethods.navigate(url);
    }
        @When("user clicks on Mail")
        public void user_clicks_on_mail () {
            String actualTitle=baseMethods.getPageTitle();
            mail.click();
        }
        @Then("system should navigate to new Authorization tab")
        public void system_should_navigate_to_yandex_mail_page () throws InterruptedException {
            Thread.sleep(4000);
            baseMethods.switchToHandle("Авторизация");
           String actualTitle=baseMethods.getPageTitle();
            String expectedTitle="Авторизация";
            Assert.assertEquals(expectedTitle,actualTitle);
        }

    @Given("user is on authorization page")
    public void user_is_on_authorization_page () {
       baseMethods.getAuthorizationPage();
    }

    @When("user enters username")
    public void user_enters_username() {
        usernameLocator.sendKeys(ConfigurationReader.get("yandexMailUsername"));
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button () {
        Login.click();
        }
    @When("user enters password")
    public void user_enters_password() {
        waits.waitForVisibility(passwordLocator,3000);
        passwordLocator.sendKeys(ConfigurationReader.get("yandexMailPassword"));
    }

    @Then("the system should display the email inbox")
    public void the_system_should_display_the_email_inbox () throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(mailboxUsername.getText().contains("abayramov16"));
        }

    }

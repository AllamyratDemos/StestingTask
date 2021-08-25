package StepDefinitions;

import Pages.GoogleSearch;
import Utilities.BaseMethods;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class googleSearch_stepDefinitions extends GoogleSearch {
    List<WebElement> allUrls;
    BaseMethods baseMethods=new BaseMethods();

    @Given("user is on google home page")
    public void user_is_on_google_home_page() {
        baseMethods.navigate(ConfigurationReader.get("googleUrl"));
    }
    @When("user types {string} in search box")
    public void user_types_an_in_search_box(String item ) {
        item="купить кофемашину bork c804";
        //in case default chrome language is not English
        if(offeredlanguage.getText().contains("English")) {
            English.click();
        }
        searchBox.click();
        searchBox.sendKeys(item);
    }
    @When("clicks on search button")
    public void clicks_on_search_button() throws InterruptedException {
        Thread.sleep(2000);
        searchButton.click();
    }
    @Then("the found result set should contain more than {int} results")
    public void the_found_result_set_should_contain_more_than_results(Integer amount) throws InterruptedException {
        Thread.sleep(2000);
        allUrls=baseMethods.getAllLinks();
        System.out.println(allUrls.size());
        Assert.assertTrue(allUrls.size()>=amount);
    }
    @Then("{string} should be found among the results")
    public void should_be_found_among_the_results(String targetResult) {
        targetResult="mvideo.ru";
        String linkText="";
        allUrls=baseMethods.getAllLinks();
        for (WebElement url : allUrls) {
            if (url.getText().contains(targetResult)) {
               linkText=url.getText();
            }
        }
        Assert.assertTrue(linkText.contains(targetResult));
        }
    }


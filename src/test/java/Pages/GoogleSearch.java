package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearch {
    public GoogleSearch() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(name = "q")
    public WebElement searchBox;

    @FindBy(xpath = "(//input[@value='Google Search'])[1]")
    public WebElement searchButton;

    @FindBy(xpath = "//a[text()='English']")
    public WebElement English;

    @FindBy(xpath = "//div[@id='SIvCob']")
    public WebElement offeredlanguage;


}
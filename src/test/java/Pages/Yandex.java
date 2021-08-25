package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Yandex {

    public Yandex(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(xpath = "//div[contains(text(),'Почта')]")
    public WebElement mail;

    @FindBy(id = "passp-field-login")
    public WebElement usernameLocator;

    @FindBy(id = "passp-field-passwd")
    public WebElement passwordLocator;

    @FindBy(xpath = "//button[@id='passp:sign-in']")
    public WebElement Login;

    @FindBy(xpath = "(//span[@class='user-account__name'])[1]")
    public WebElement mailboxUsername;
}

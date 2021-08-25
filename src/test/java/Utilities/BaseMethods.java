package Utilities;

import Pages.Yandex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class BaseMethods {
    public void navigate(String url) {
        Driver.get().get(url);
    }

    public String getPageTitle() {
        return Driver.get().getTitle();
    }

    public void switchToHandle(String title) {
        Set<String> windowhandles = Driver.get().getWindowHandles();
        for (String handle : windowhandles) {
            Driver.get().switchTo().window(handle);
            if (Driver.get().getTitle().equals(title)) {
                break;
            }
        }
    }

    public void getAuthorizationPage(){
        Yandex yandex=new Yandex();
        Driver.get().get(ConfigurationReader.get("yandexUrl"));
        yandex.mail.click();
        Set<String> windowhandles = Driver.get().getWindowHandles();
        for (String handle : windowhandles) {
            Driver.get().switchTo().window(handle);
            if (Driver.get().getTitle().equals("Авторизация")) {
                break;
            }
        }
    }
    public List<WebElement> getAllLinks(){

        return Driver.get().findElements(By.tagName("a"));
    }
}
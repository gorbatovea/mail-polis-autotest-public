package core.page;

import bot.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public  void doLogin(Bot bot) {
        getBy("https://ok.ru/");
        typeKeys(By.id("field_email"), bot.getEmail());
        typeKeys(By.id("field_password"), bot.getPwd());
        typeKeys(By.id("field_password"), Keys.ENTER);
    }

    protected void getBy(String url) {
        super.driver.get(url);
    }

    @Override
    protected void check(boolean condition, By by) {

    }
}

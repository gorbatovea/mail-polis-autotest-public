package core.page;

import bot.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.*;

public class LoginPage extends PageBase {

    private final String LOGIN_FORM = "//div[@class='anonym_login_cnt js-login-state']";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public UserMainPage doLogin(Bot bot) {
        typeKeys(By.id("field_email"), bot.getEmail());
        typeKeys(By.id("field_password"), bot.getPwd());
        typeKeys(By.id("field_password"), Keys.ENTER);
        return new UserMainPage(driver);
    }

    protected void getBy(String url) {
        super.driver.get(url);
    }

    @Override
    protected void check() {
        assertTrue("login page didn't appear",
                explicitWait(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath(LOGIN_FORM)),
                        10,
                        500));
    }
}

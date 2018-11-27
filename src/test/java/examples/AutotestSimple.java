package examples;

import bot.Bot;
import core.page.GroupPage;
import core.page.LoginPage;
import core.TestBase;
import core.page.UserMainPage;
import org.junit.*;

public class AutotestSimple extends TestBase {
    protected Bot loginBot;

    /*@Before
    public void init() {
        this.loginBot = Bot.generateDefault();
    }

    @Test
    public void testOkGroups() throws Exception {
        LoginPage session = new LoginPage(driver);
        session.doLogin(this.loginBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.navigateToGroups();
        GroupPage group = new GroupPage(driver);
        group.createGroup();
    }*/

}

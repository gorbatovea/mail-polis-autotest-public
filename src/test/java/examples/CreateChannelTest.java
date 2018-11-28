package examples;

import bot.Bot;
import core.page.LoginPage;
import core.page.UserMainPage;
import core.TestBase;
import core.page.VideoPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreateChannelTest extends TestBase {
    protected Bot loginBot;

    @Before
    public void init() {
        this.loginBot = Bot.generateDefault();
    }

    public void prepare() {

    }

    @Test
    public void createChannel() {
        LoginPage session = new LoginPage(driver);
        session.doLogin(this.loginBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.navigateToVideos();
        VideoPage videoPage = new VideoPage(driver);
        videoPage.expandMyVideos();
        videoPage.createChannel();
    }

    public void cleanUp() {
        VideoPage videoPage = new VideoPage(driver);
        videoPage.removeChannel();
    }
}
package examples;

import bot.Bot;
import core.TestBase;
import core.page.LoginPage;
import core.page.UserMainPage;
import core.page.VideoPage;
import org.junit.Before;
import org.junit.Test;

public class AddVideoByUrlTest extends TestBase {
    protected Bot loginBot;

    @Before
    public void init() {
        this.loginBot = Bot.generateDefault();
    }

    @Test
    public void addVideoByUrl() {
        LoginPage session = new LoginPage(driver);
        session.doLogin(this.loginBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.navigateToVideos();
        VideoPage videoPage = new VideoPage(driver);
        videoPage.expandMyVideos();
        videoPage.addVideo();
    }

    public void cleanUp() {
        VideoPage videoPage = new VideoPage(driver);
        videoPage.removeVideo();
    }
}

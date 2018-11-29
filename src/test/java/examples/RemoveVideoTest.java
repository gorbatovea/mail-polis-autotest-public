package examples;

import bot.Bot;
import core.TestBase;
import core.page.LoginPage;
import core.page.UserMainPage;
import core.page.VideoPage;
import org.junit.Before;
import org.junit.Test;

public class RemoveVideoTest extends TestBase {
    protected Bot loginBot;

    @Before
    public void init() {
        this.loginBot = Bot.generateDefault();
        prepare();
    }

    private void prepare() {
        LoginPage session = new LoginPage(driver);
        session.doLogin(this.loginBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.navigateToVideos();
        VideoPage videoPage = new VideoPage(driver);
        videoPage.expandMyVideos();
        videoPage.addVideo();
        driver.get(baseUrl);
    }

    @Test
    public void removeVideo() {
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.navigateToVideos();
        VideoPage videoPage = new VideoPage(driver);
        videoPage.removeVideo();
    }

    public void cleanUp() {

    }
}

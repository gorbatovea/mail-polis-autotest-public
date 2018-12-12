package examples;

import bot.Bot;
import core.TestBase;
import core.page.LoginPage;
import core.page.UserMainPage;
import core.page.VideoPage;
import org.junit.Before;
import org.junit.Test;

public class FindVideoTest extends TestBase {
    private static final String VIDEO_URL = "https://www.youtube.com/watch?v=tNHWjcCyoEk";
    private static final String VIDEO_NAME = "CANON M3 CINEMATIC VIDEO TEST - Lakes | Cinematography | TechGenieT3G";

    protected Bot loginBot;

    @Before
    public void init() {
        this.loginBot = Bot.generateDefault();
        prepare();
    }

    @Test
    public void searchVideo() {
        new UserMainPage(driver)
                .navigateToVideos()
                .searchVideo(VIDEO_NAME);
        driver.get(baseUrl);
    }

    private void prepare() {
        new LoginPage(driver)
                .doLogin(this.loginBot)
                .navigateToVideos()
                .expandMyVideos()
                .addVideo(VIDEO_URL)
                .chooseUrlUpload()
                .uploadVideoByUrl(VIDEO_URL)
                .confirmVideoAdd(VIDEO_NAME);
        driver.get(baseUrl);
    }

    protected void cleanUp() {
        new UserMainPage(driver)
                .navigateToVideos()
                .removeVideo()
                .delete()
                .confirmVideoDelete(VIDEO_NAME);
    }
}

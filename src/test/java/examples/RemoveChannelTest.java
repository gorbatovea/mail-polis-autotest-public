package examples;

import bot.Bot;
import core.page.LoginPage;
import core.page.UserMainPage;
import core.TestBase;
import core.page.VideoPage;
import org.junit.Before;
import org.junit.Test;

public class RemoveChannelTest extends TestBase {
    private static final String CHANNEL_NAME = "AutoTestChannel";

    protected Bot loginBot;

    @Before
    public void init() {
        this.loginBot = Bot.generateDefault();
        prepare();
    }

    private void prepare() {
        new LoginPage(driver)
                .doLogin(this.loginBot)
                .navigateToVideos()
                .expandMyVideos()
                .popUpChannelCreationPage(CHANNEL_NAME)
                .createChannel(CHANNEL_NAME)
                .confirmChannelCreation(CHANNEL_NAME);
        driver.get(baseUrl);
    }

    @Test
    public void removeChannel() {
        new UserMainPage(driver)
                .navigateToVideos()
                .chooseChannel(CHANNEL_NAME)
                .deleteChannel(CHANNEL_NAME)
                .confirmChannelDelete(CHANNEL_NAME);
    }

    public void cleanUp() {

    }
}

package core.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class ChannelDeletePage extends PageBase {

    private final String CHANNEL_DELETE_BUTTON = "//input[@class='vl_btn']";

    public ChannelDeletePage(WebDriver webDriver) {
        super(webDriver);
    }

    public VideoPage deleteChannel(final String channel) {
        click(CHANNEL_DELETE_BUTTON);
        return new VideoPage(driver);
    }

    @Override
    protected void check() {
        assertTrue("channel delete button didn't appear", explicitWait(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(CHANNEL_DELETE_BUTTON)),
                5,
                500));
    }
}

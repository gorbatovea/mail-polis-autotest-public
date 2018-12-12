package core.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class ChannelCreationPage extends PageBase {
    protected final String CREATE_CHANNEL_REF = "//a[@class='ml-4x tico wl']";
    private final String CHANNEL_INPUT_NAME = "//input[@name='st.vv_albumName']";
    private final String CHANNEL_CREATION_SUBMIT = "//input[@class='vl_btn']";

    public ChannelCreationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public VideoPage createChannel(final String channel) {
        typeKeys(By.xpath(CHANNEL_INPUT_NAME), channel);
        click(CHANNEL_CREATION_SUBMIT);
        return new VideoPage(driver);
    }

    @Override
    protected void check() {
        assertTrue("channel name input didn't appear", explicitWait(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(CREATE_CHANNEL_REF)),
                5,
                500));
    }
}

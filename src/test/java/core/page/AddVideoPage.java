package core.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class AddVideoPage extends PageBase {

    private final String VIDEO_UPLOADER_BUTTON = "//span[@data-target='video_uploader_link']";
    private final String VIDEO_URL_INPUT = "//input[@name='st.vv_ugLink']";
    private final String VIDEO_PREVIEW = "//div[@class='vid-card_n_w']";
    private final String UPLOAD_BUTTON = "//button[@class='vl_btn']";

    public AddVideoPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddVideoPage chooseUrlUpload() {
        click(VIDEO_UPLOADER_BUTTON);
        assertTrue("video url input doesn't appear", explicitWait(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(VIDEO_URL_INPUT)),
                5,
                500));
        return this;
    }

    public VideoPage uploadVideoByUrl(final String url) {
        typeKeys(By.xpath(VIDEO_URL_INPUT), url);
        assertTrue("video preview didn't appear", explicitWait(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(VIDEO_PREVIEW)),
                5,
                500));
        click(UPLOAD_BUTTON);
        return new VideoPage(driver);
    }

    @Override
    protected void check() {
        assertTrue("video uploader button doesn't appear", explicitWait(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(VIDEO_UPLOADER_BUTTON)),
                5,
                500));
    }
}

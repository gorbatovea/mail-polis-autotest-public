package core.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import transformer.Transformer;
import wrapper.VideoSideBarWrapper;
import wrapper.VideoWrapper;
import wrapper.Wrapper;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class VideoPage extends PageBase {
    private static final String VIDEO_VITRINA_MY_ALBUMS_MENU = "//div[@id='hook_Block_VideoVitrinaMyAlbumsMenu']";
    private static final String VIDEO_SIDE_BAR_LIST = "//span[@class='mml_cat_n ellip']";
    private static final String CREATE_CHANNEL_REF = "//a[@class='ml-4x tico wl']";
    private static final String CHANNEL_DELETE_BUTTON = "//span[@class='tico_img vl_ic_delete']";
    private static final String ADD_VIDEO_BUTTON = "//a[@class='tico wl vv-upload-btn']";
    private static final String VIDEO_ELEMENT_LOCATOR = "//div[@class='vid-card js-draggable']";
    private static final String SEARCH_INPUT = "//input[@class='search-input_it it']";
    private static final String VITRINA_UPLOAD_BUTTON = "//div[@id='hook_Block_VideoVitrinaUploadButton']";

    public VideoPage(WebDriver webDriver) {
        super(webDriver);
    }

    public VideoPage expandMyVideos() {
        List<Wrapper> sideElements =
                Transformer
                        .getInstance()
                        .getList(
                                driver.findElements(By.xpath(VIDEO_SIDE_BAR_LIST)),
                                e -> new VideoSideBarWrapper(e, driver));
        assertEquals(21, sideElements.size());
        sideElements.get(14).click();
        assertTrue("Can't locate menu", explicitWait(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO_VITRINA_MY_ALBUMS_MENU)),
                5,
                500));
        return this;
    }

    public ChannelCreationPage popUpChannelCreationPage(final String channel) {
        click(CREATE_CHANNEL_REF);
        return new ChannelCreationPage(driver);
    }

    public VideoPage confirmChannelCreation(final String channel) {
        assertTrue("can't locate created channel", explicitWait(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(getChannelLocatorByName(channel))),
                5,
                500));
        return this;
    }

    private String getChannelLocatorByName(final String channel) {
        return "//div[@class='mml_ucard_n_g textWrap' and text()='" + channel + "']";
    }

    public ChannelDeletePage chooseChannel(final String channel) {
        click(getChannelLocatorByName(channel));
        assertTrue("channel delete button didn't appear", explicitWait(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(CHANNEL_DELETE_BUTTON)),
                5,
                500));
        click(CHANNEL_DELETE_BUTTON);
        return new ChannelDeletePage(driver);
    }

    public VideoPage confirmChannelDelete(final String channel) {
        assertTrue("removed channel didn't disappear",explicitWait(
                ExpectedConditions.invisibilityOfElementLocated(
                        By.xpath(getChannelLocatorByName(channel))),
                5,
                500));
        return this;
    }

    public AddVideoPage addVideo(final String videoUrl) {
        click(ADD_VIDEO_BUTTON);
        return new AddVideoPage(driver);
    }

    public VideoPage confirmVideoAdd(final String name) {
        List<Wrapper> list = Transformer
                .getInstance()
                .getList(driver.findElements(By.xpath(VIDEO_ELEMENT_LOCATOR)),
                        e -> new VideoWrapper(e, driver));
        assertTrue(list.size() > 0);
        long count = list
                .stream()
                .filter(w -> ((VideoWrapper) w).getName().equals(name))
                .count();
        assertTrue("no videos found", count > 0);
        return this;
    }

    public VideoPage confirmVideoDelete(final String name) {
        assertTrue("video didn't disappear",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(getVideoLocatorByName(name))),
                        5,
                        500));
        return this;
    }

    public VideoDeletePage removeVideo() {
        List<Wrapper> list = Transformer
                .getInstance()
                .getList(driver.findElements(By.xpath(VIDEO_ELEMENT_LOCATOR)),
                        e -> new VideoWrapper(e, driver));
        assertTrue(list.size() > 0);
        VideoWrapper videoWrapper = (VideoWrapper) list.stream().findFirst().get();
        videoWrapper.delete();
        return new VideoDeletePage(driver);
    }

    public void searchVideo(final String name) {
        typeKeys(By.xpath(SEARCH_INPUT), name);
        List<Wrapper> list =
                Transformer
                        .getInstance()
                        .getList(driver.findElements(
                                By.xpath(VIDEO_ELEMENT_LOCATOR)),
                                e -> new VideoWrapper(e, driver));
        assertTrue("no videos found", list.size() > 0);
        long count =
                list.stream()
                        .filter(w -> ((VideoWrapper)w).getName().equals(name))
                        .count();
        assertTrue("no videos with specified name", count > 0);
    }

    private String getVideoLocatorByName(final String name) {
        return "//div[@class='vid-card_cnt']//*[text()='" + name + "']";
    }

    @Override
    protected void check() {
        assertTrue("video page didn't appear",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(VITRINA_UPLOAD_BUTTON)),
                        5,
                        500));
    }
}

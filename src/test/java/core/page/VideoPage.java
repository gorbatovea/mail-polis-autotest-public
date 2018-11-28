package core.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VideoPage extends PageBase {

    protected static final String CHANNEL_NAME = "AutoTestChannel";
    protected static final String VIDEO_URL = "https://www.youtube.com/watch?v=tNHWjcCyoEk";
    protected static final String VIDEO_NAME = "CANON M3 CINEMATIC VIDEO TEST - Lakes | Cinematography | TechGenieT3G";

    public VideoPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void expandMyVideos() {
        click("//*[@id=\"vv_btn_myVideo\"]/span/span[2]");
        assertTrue(explicitWait(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='hook_Block_VideoVitrinaMyAlbumsMenu']")),
                5,
                500));
    }

    public void createChannel() {
        click("//*[@id='vv_btn_create_channel_left_menu']/div");
        typeKeys(By.xpath("//*[@id='vv-album-form']/div[1]/div/input"), CHANNEL_NAME);
        click("//*[@id='vv-album-form']/div[2]/input");
        assertTrue(explicitWait(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='mml_ucard_n_g textWrap' and text()='" + CHANNEL_NAME + "']")),
                5,
                500));
    }

    public void removeChannel(){
        click("//div[@class='mml_ucard_n_g textWrap' and text()='" + CHANNEL_NAME + "']");
        click("//a[text()='Delete']");
        click("//input[@value='Delete']");
        assertTrue(explicitWait(
                ExpectedConditions.invisibilityOfElementLocated(
                        By.xpath("//div[@class='mml_ucard_n_g textWrap' and text()='" + CHANNEL_NAME + "']")),
                5,
                500));
    }

    public void addVideo() {
        click("//a[@class='tico wl vv-upload-btn']");
        click("//span[@data-target='video_uploader_link']");
        typeKeys(By.xpath("//input[@name='st.vv_ugLink']"), VIDEO_URL);
        assertTrue(explicitWait(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[@class='vl_btn']")),
                5,
                500));
        click("//button[@class='vl_btn']");
        assertTrue(explicitWait(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@id='hook_Block_VideoVitrinaMovies']//div[@class='vid-card js-draggable']")),
                5,
                500));
    }

    public void removeVideo() {
        Actions actions = new Actions(driver);
        WebElement deleteButton = get(By.xpath("//div[@id='hook_Block_VideoVitrinaMovies']//div[@class='vid-card js-draggable']//a[@title='Delete']"));
        actions.moveToElement(deleteButton).click().build().perform();
        click("//input[@value='Delete']");
        assertFalse(explicitWait(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@id='hook_Block_VideoVitrinaMovies']//div[@class='vid-card js-draggable']")),
                5,
                500));
    }

    public void searchVideo() {
        typeKeys(By.xpath("//input[@class='search-input_it it']"), VIDEO_NAME);
        assertFalse(explicitWait(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='vid-card_cnt']//*[text()='" + VIDEO_NAME + "']")),
                5,
                500));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='hook_Block_VideoVitrinaUploadButton']")),
                5,
                500));
    }
}

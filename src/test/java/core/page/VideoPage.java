package core.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import static org.junit.Assert.*;

public class VideoPage extends PageBase {

    protected static final String CHANNEL_NAME = "AutoTestChannel";
    protected static final String VIDEO_URL = "https://www.youtube.com/watch?v=tNHWjcCyoEk";
    protected static final String VIDEO_NAME = "CANON M3 CINEMATIC VIDEO TEST - Lakes | Cinematography | TechGenieT3G";

    public VideoPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void expandMyVideos() {
        click("//*[@id=\"vv_btn_myVideo\"]/span/span[2]");
    }

    public void createChannel() {
        click("//*[@id=\"vv_btn_create_channel_left_menu\"]/div");
        typeKeys(By.xpath("//*[@id=\"vv-album-form\"]/div[1]/div/input"), CHANNEL_NAME);
        click("//*[@id=\"vv-album-form\"]/div[2]/input");
        waitFor(100);
        check(true, By.xpath("//div[@class='mml_ucard_n_g textWrap' and text()='" + CHANNEL_NAME + "']"));
    }

    public void removeChannel(){
        click("//div[@class='mml_ucard_n_g textWrap' and text()='" + CHANNEL_NAME + "']");
        click("//a[text()='Delete']");
        click("//input[@value='Delete']");
        waitFor(100);
        check(false, By.xpath("//div[@class='mml_ucard_n_g textWrap' and text()='" + CHANNEL_NAME + "']"));
    }

    public void addVideo() {
        click("//a[@class='tico wl vv-upload-btn']");
        click("//span[@data-target='video_uploader_link']");
        typeKeys(By.xpath("//input[@name='st.vv_ugLink']"), VIDEO_URL);
        waitFor(3000);
        click("//button[@class='vl_btn']");
        waitFor(400);
        check(true, By.xpath("//div[@id='hook_Block_VideoVitrinaMovies']//div[@class='vid-card js-draggable']"));
    }

    public void removeVideo() {
        Actions actions = new Actions(driver);
        WebElement deleteButton = get(By.xpath("//div[@id='hook_Block_VideoVitrinaMovies']//div[@class='vid-card js-draggable']//a[@title='Delete']"));
        actions.moveToElement(deleteButton).click().build().perform();
        click("//input[@value='Delete']");
        waitFor(400);
        check(false, By.xpath("//div[@id='hook_Block_VideoVitrinaMovies']//div[@class='vid-card js-draggable']"));
    }

    public void searchVideo() {
        typeKeys(By.xpath("//input[@class='search-input_it it']"), VIDEO_NAME);
        waitFor(1000);
        check(true, By.xpath("//div[@class='vid-card_cnt']//*[text()='" + VIDEO_NAME + "']"));
    }

    @Override
    protected void check(boolean condition, By by) {
        assertEquals(
                condition,
                isElementPresent(by)
        );
    }
}

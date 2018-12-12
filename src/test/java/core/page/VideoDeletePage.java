package core.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class VideoDeletePage extends PageBase {

    private final String VIDEO_DELETE_BUTTON = "//input[@class='vl_btn']";

    public VideoDeletePage(WebDriver webDriver) {
        super(webDriver);
    }

    public VideoPage delete() {
        click(VIDEO_DELETE_BUTTON);
        return new VideoPage(driver);
    }

    @Override
    protected void check() {
        assertTrue("video delete button doesn't appear", explicitWait(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(VIDEO_DELETE_BUTTON)),
                5,
                500));
    }
}

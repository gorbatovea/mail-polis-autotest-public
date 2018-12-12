package core.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class UserMainPage extends PageBase {

    private final String VIDEO_PAGE_REF = "//div[@class='toolbar_nav_a toolbar_nav_a__video']";
    private final String BLOCK_AVATAR = "//div[@id='hook_Block_Avatar']";

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    public VideoPage navigateToVideos() {
        click(VIDEO_PAGE_REF);
        return new VideoPage(driver);
    }

    @Override
    protected void check() {
    assertTrue("main page didn't appear",
        explicitWait(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath(BLOCK_AVATAR)),
            5,
            500));
    }
}

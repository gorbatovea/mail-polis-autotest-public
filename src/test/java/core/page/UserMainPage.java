package core.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserMainPage extends PageBase {

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGroups() {
        click("//i[@class='tico_img ic ic_nav_groups-v2']");
    }

    public void navigateToVideos() {
        click("//*[@id=\"hook_Block_TopMenuVideo\"]/div/div[1]/div");
    }

    @Override
    protected void check(boolean condition, By by) {

    }
}

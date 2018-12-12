package wrapper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VideoSideBarWrapper extends Wrapper{

    public VideoSideBarWrapper(WebElement element, WebDriver driver) {
        super(element, driver);
    }

    public void click() {
        this.element.click();
    }
}

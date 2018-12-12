package wrapper;

import core.page.VideoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.Callable;
import java.util.function.Predicate;

import static org.junit.Assert.assertTrue;

public class VideoWrapper extends Wrapper {

  private final String VIDEO_NAME = "//div[@class='vid-card_n']";
  private final String DELETE_BUTTON = "//a[@class='vid-card_ac_i ic vl_ic_delete']";

  public VideoWrapper(WebElement element, WebDriver driver) {
    super(element, driver);
  }

  @Override
  public void click() {}

  public String getName() {
    By name = By.xpath(VIDEO_NAME);
    assertTrue(isElementPresent(name));
    return this.element.findElement(name).getText();
  }

  public VideoWrapper delete() {
    By deleteButton = By.xpath(DELETE_BUTTON);
    assertTrue(isElementPresent(deleteButton));
    Actions actions = new Actions(driver);
    actions.moveToElement(this.element.findElement(deleteButton)).click().build().perform();
    return this;
  }

}

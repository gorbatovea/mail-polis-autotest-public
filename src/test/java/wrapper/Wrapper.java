package wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

abstract public class Wrapper {
    protected final WebElement element;
    protected final WebDriver driver;

    public Wrapper(WebElement element, WebDriver driver) {
        this.element = element;
        this.driver = driver;
    }

    protected boolean isElementPresent(By by) {
        try {
            this.element.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    abstract public void click();
}

package core.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupPage extends PageBase {

    public GroupPage(WebDriver driver) {
        super(driver);
    }

    public  void createGroup() {
        click("//i[@class='add-stub_img add-stub_img__group-create']");
        click("//div[@class='create-group-dialog_cnt']/div[contains(text(),'Public page')]");
        setTitle();
        setDescription();
        click("//input[@class='button-pro form-actions_yes']");
    }

    public  void setTitle() {
        typeKeys(By.id("field_name"), "Autotests");
    }

    public  void setDescription() {
        typeKeys(By.id("field_description"), "Test Test Test...");
    }

    @Override
    protected void check(boolean condition, By by) {

    }
}

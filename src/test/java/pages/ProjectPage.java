package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ProjectPage extends BasePage {

    @FindBy(xpath = "//body")
    private WebElement body;

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getBody() {
        return body;
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ExplorePage extends BasePage {

    @FindBy(xpath = "//div[@class='discoverableCard']")
    private WebElement card;

    @FindBy(xpath = "//div[@class='exploreMore']//a[contains(text(), 'show more')]")
    WebElement showMoreResults;

    @FindBy(xpath = "//div[@class='exploreMore']//a[contains(text(), 'View All Trending')]")
    WebElement viewAllTrinding;

    public ExplorePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCard() {
        return card;
    }

    public WebElement getShowMoreResults() {
        return showMoreResults;
    }

    public WebElement getViewAllTrinding() {
        return viewAllTrinding;
    }
}

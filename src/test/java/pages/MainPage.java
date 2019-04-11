package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[@class='layoutHeader-generalHeader-searchButton']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='featuredProject-content']")
    private WebElement featuredProjectsDescription;

    @FindBy(xpath = "//a[@id='main']")
    private WebElement featuredProjects;

    @FindBy(xpath = "//div[@class='arrowContainer'][1]")
    private WebElement previousButton;

    @FindBy(xpath = "//div[@class='arrowContainer'][2]")
    private WebElement nextButton;

    @FindBy(xpath = "//div[contains(@class, 'arrowIndex')]")
    private WebElement arrowIndex;

    @FindBy(xpath = "//input[@class='layoutHeader-searchBar-input']")
    private WebElement searchForm;

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getFeaturedProjects() {
        return featuredProjects;
    }

    public WebElement getFeaturedProjectsDescription() {
        return featuredProjectsDescription;
    }

    public WebElement getPreviousButton() {
        return previousButton;
    }

    public WebElement getNextButton() {
        return nextButton;
    }

    public WebElement getArrowIndex() {
        return arrowIndex;
    }

    public WebElement getSearchForm() {
        return searchForm;
    }
}

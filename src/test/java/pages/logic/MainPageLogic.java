package pages.logic;

import driver.DriverManager;
import org.openqa.selenium.Keys;
import pages.ExplorePage;
import pages.MainPage;

public class MainPageLogic {

    private MainPage mainPage;

    public MainPageLogic(){
        mainPage = new MainPage(DriverManager.currentDriver());
    }

    public MainPage get(){
        return mainPage;
    }

    public ExplorePageLogic findInformation(String information){
        this.get().getSearchButton().click();
        this.get().getSearchForm().sendKeys(information);
        this.get().getSearchForm().sendKeys(Keys.ENTER);
        return new ExplorePageLogic();
    }

}

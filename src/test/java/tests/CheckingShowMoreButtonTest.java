package tests;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import pages.logic.ExplorePageLogic;
import pages.logic.MainPageLogic;
import tests.base.BaseTest;

import java.util.List;

public class CheckingShowMoreButtonTest extends BaseTest {

    @Test(parameters = {"informationTwo"})
    public void checkingShowMoreButton(@Optional String informationTwo){
        MainPageLogic mainPageLogic = new MainPageLogic( );

        ExplorePageLogic explorePageLogic = mainPageLogic.findInformation(informationTwo);


        List<WebElement> listProjects = explorePageLogic.get().getCard().findElements(By.xpath(("//div[contains(@class, 'discoverableCard-title')]")));


        while(explorePageLogic.get().getShowMoreResults().isDisplayed() && !explorePageLogic.get().getViewAllTrinding().isDisplayed()) {

            explorePageLogic.get( ).getShowMoreResults( ).click();

            new WebDriverWait(DriverManager.currentDriver(), 10)
                    .until(ExpectedConditions.visibilityOfAllElements(listProjects));

            List<WebElement> bufListProjects = listProjects;
            listProjects = explorePageLogic.get( ).getCard( ).findElements(By.xpath((".//div[contains(@class, 'discoverableCard-title')]")));

            Assert.assertTrue(bufListProjects.size( ) < listProjects.size( ));
        }
    }

}

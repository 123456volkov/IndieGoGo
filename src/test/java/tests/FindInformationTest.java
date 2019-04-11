package tests;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import pages.logic.ExplorePageLogic;
import pages.logic.MainPageLogic;
import pages.logic.ProjectPageLogic;
import tests.base.BaseTest;

public class FindInformationTest extends BaseTest {

    @Test(parameters = {"information", "nameOfProject", "text"})
    public void test(@Optional String information, @Optional String nameOfProject, @Optional String text){

        MainPageLogic mainPageLogic =  new MainPageLogic();

        ExplorePageLogic explorePageLogic = mainPageLogic.findInformation(information);

        ProjectPageLogic projectPageLogic = explorePageLogic.openProject(nameOfProject);

        Assert.assertTrue(projectPageLogic.get().getBody().findElement(By.xpath(String.format("//*[contains(text(),'%s')]",text ))) != null);
    }
}

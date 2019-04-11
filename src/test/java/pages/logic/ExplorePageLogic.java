package pages.logic;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.ExplorePage;
import pages.ProjectPage;

import java.util.ArrayList;
import java.util.List;

public class ExplorePageLogic {

    private ExplorePage explorePage;

    public ExplorePageLogic(){
        explorePage = new ExplorePage(DriverManager.currentDriver());
    }

    public ExplorePage get(){
        return explorePage;
    }

    public ProjectPageLogic openProject(String nameOfProject){

        List<WebElement> listProjects = this.get().getCard().findElements(By.xpath((".//div[contains(@class, 'discoverableCard-title')]")));

        WebElement[] projects = new WebElement[listProjects.size()];
        for (int i = 0; i < projects.length; i++)
            projects[i] = listProjects.get(i);

        int indexOfProject = getIndex(projects, nameOfProject);
        //Assert.assertTrue(indexOfProject >= 0, "Не найдено проектов с таким именем");
        Assert.assertNotEquals(indexOfProject, 0);

        projects[indexOfProject].click();

        return new ProjectPageLogic();
    }

    protected int getIndex(WebElement[] projectsList, String nameOfProject){
        int index = -1;
        for(int i = 0; i < projectsList.length; i++){
            if (projectsList[i].getText().toLowerCase().equals(nameOfProject
                    .trim().toLowerCase())){
                index  = i;
                break;
            }
        }
        return index;
    }
}

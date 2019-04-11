package pages.logic;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import pages.ProjectPage;

public class ProjectPageLogic {

    private ProjectPage projectPage = new ProjectPage(DriverManager.currentDriver());

    public ProjectPage get(){
        return this.projectPage;
    }

}

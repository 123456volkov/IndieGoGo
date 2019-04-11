package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.logic.MainPageLogic;
import tests.base.BaseTest;
import data.FeaturedProject;

import java.util.ArrayList;

public class FeaturedProjectsTest extends BaseTest {

    ArrayList<FeaturedProject> projectsList;

    @DataProvider(name = "projects")
    public Object[][] parameterIntTestProvider(){
        return new Object[][]{
                {"A Portable Personal Cinema", "LUCI immers delivers an incredible visual experience for entertainment"},
                {"1080P Android TV Portable Projector", "The MoGo Pro is the award-winning portable projector by XGIMI"},
                {"Small, Intelligent & Autonomous", "Microdrone 4.0 is a palm sized drone that captures smooth aerial video"},
                {"The Smartest, Foldable, All Terrain E-Bike", "SDREAM has GPS and the most streamlined design"}
        };
    }


    @BeforeClass
    public void getProgectsList(){
        MainPageLogic mainPageLogic = new MainPageLogic();
        projectsList = getListOfFeaturedProjects(mainPageLogic);
    }

    @Test(dataProvider = "projects")
    public void featuredProjects(String headLine, String tagLine){

        FeaturedProject bufFeaturedProject = new FeaturedProject();

        bufFeaturedProject.setFeaturedProjectHeadline(headLine);
        bufFeaturedProject.setFeaturedProjectTagLine(tagLine);

        Assert.assertTrue(contains(projectsList, bufFeaturedProject));
    }


    public boolean contains(ArrayList<FeaturedProject> projectsList,  FeaturedProject bufFeaturedProject){
        boolean flag = false;
        for (FeaturedProject featuredProject : projectsList){
            if (featuredProject.getFeaturedProjectHeadline()
                        .trim()
                        .toLowerCase()
                    .equals(bufFeaturedProject.getFeaturedProjectHeadline()
                            .toLowerCase()
                            .trim())
                    && featuredProject.getFeaturedProjectTagLine()
                        .toLowerCase()
                        .trim()
                    .equals(bufFeaturedProject.getFeaturedProjectTagLine()
                            .toLowerCase()
                            .trim())){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public ArrayList<FeaturedProject> getListOfFeaturedProjects(MainPageLogic mainPageLogic){

        ArrayList<FeaturedProject> arrayList = new ArrayList<FeaturedProject>();
        int arrowIndex = 0;

        for ( String number : mainPageLogic.get().getArrowIndex().getText().split("/", 2)) {
           arrowIndex = Integer.parseInt(number.trim());
        }

        for (int i = 0; i < arrowIndex; i++){
            FeaturedProject featuredProject = new FeaturedProject();

            String headLine = mainPageLogic.get().getFeaturedProjectsDescription().findElement(By.cssSelector(".featuredProject-headline")).getText();
            featuredProject.setFeaturedProjectHeadline(headLine);

            String tagLine = mainPageLogic.get().getFeaturedProjectsDescription().findElement(By.cssSelector(".featuredProject-tagline")).getText();
            featuredProject.setFeaturedProjectTagLine(tagLine);

            arrayList.add(featuredProject);

            mainPageLogic.get().getNextButton().click();
        }
        return arrayList;
    }
}

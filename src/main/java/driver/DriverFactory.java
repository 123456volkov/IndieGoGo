package driver;

import driver.DriverName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {


    public static WebDriver createDriver(String nameOfDriver) {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver73.exe");
        System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");

        if (nameOfDriver.matches(DriverName.Chrome)) {
            return new ChromeDriver();
        }
        if (nameOfDriver.matches(DriverName.FireFox)) {
            return new FirefoxDriver();
        }
        return null;
    }

//
//
//       protected static DriverFactory driverFactory;
//
//
//          protected synchronized static DriverFactory getInstance(){
//              if (driverFactory == null){
//                  driverFactory = new DriverFactory();
//              }
//              return driverFactory;
//          }
//
//          protected WebDriver driver;
//
//          public synchronized static WebDriver currentDriver(String nameOfDriver){
//              return getInstance().getDriver(nameOfDriver);
//          }
//
//          protected synchronized WebDriver getDriver(String nameOfDriver){
//              System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver73.exe");
//              System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
//              if (driver == null){
//                  if (nameOfDriver.matches(DriverName.Chrome))
//                      driver = new ChromeDriver();
//                  if (nameOfDriver.matches(DriverName.FireFox))
//                      driver = new FirefoxDriver();
//              }
//              return driver;
//          }

}

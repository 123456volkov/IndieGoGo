package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<DriverManager> driverManager = new ThreadLocal<DriverManager>();

    protected synchronized static DriverManager getInstance(){
        if (driverManager.get() == null){
                driverManager.set(new DriverManager());
        }
        return driverManager.get();
    }

    protected WebDriver driver;

    public static WebDriver currentDriver(){
        return getInstance().getDriver();
    }

    protected synchronized WebDriver getDriver(){
        if (driver == null){

//            driver = DriverFactory.currentDriver(DriverName.Chrome);
            DriverFactory driverFactory = new DriverFactory();
            driver = driverFactory.createDriver(DriverName.Chrome);

        }
        return driver;
    }

//    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<WebDriver>();
//
//    public synchronized static void setDriverThread(final String nameOfDriver){
//        final DriverFactory driverFactory = new DriverFactory();
//        driverThread.set(driverFactory.createDriver(nameOfDriver));
//    }
//
//    public synchronized static WebDriver getDriverThread(){
//        return driverThread.get();
//    }


}

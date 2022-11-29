package Hooks;

import Factory.DriverFactory;
import Helpers.ControlHelpers;
import Helpers.PicoContainer;
import Pages.Homepage;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class MyHooks {
    public WebDriver driver;
    private final PicoContainer picoObj;

    public MyHooks(PicoContainer context){
        this.picoObj = context;
    }

    @BeforeAll
    public static void beforeTestRun() {
        System.out.println("BeforeTestRun");
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
    if (scenario.isFailed()) {
            System.out.println("scenario failed so  i am here");
           final byte[] screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
           scenario.attach(screenshot,"image/png","image");
            System.out.println("attach taken so  i am here");
     }
//        try
//        {
//            final byte[] screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot,"image/png","image");
//        }
//        catch (Exception ex)
//        {
//            System.out.println(ex.getMessage());
//        }

    }
    @AfterAll
    public static void afterTestRun()
    {
        System.out.println("AfterTestRun");
    }

    @Before
    public void before(Scenario scenario) throws Exception {

        System.out.println("BEFORE: THREAD ID : " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME: " + scenario.getName());
        driver= DriverFactory.initializeDriver("chrome");
        ControlHelpers controlHelpers=new ControlHelpers(driver);
        picoObj.driver = driver;
        Homepage homepage=new Homepage(picoObj.driver);
           }

    @After
    public void after(Scenario scenario)
    {
        System.out.println("AFTER: THREAD ID : " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME: " + scenario.getName());
        for(String tag : scenario.getSourceTagNames()){
            System.out.println("Tag : " + tag);
        }
      //  picoObj.driver.quit();

    }
}

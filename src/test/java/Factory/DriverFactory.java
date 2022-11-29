package Factory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver initializeDriver(String browser)
    {
        WebDriver driver;
        switch (browser) {
            case "chrome" ->
            {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {

                System.setProperty("webdriver.gecko.driver", "F:\\Workspace\\newletskodeit\\src\\test\\resources\\geckodriver.exe");

                //Instantiating driver object and launching browser
                driver = new FirefoxDriver();
            }
            default -> throw new IllegalStateException("INVALID BROWSER: " + browser);
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://courses.letskodeit.com/practice");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        return driver;
    }
}

package Pages;

import Helpers.ControlHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Iframe {
    ControlHelpers controlHelpers;
    public WebDriver driver;
    By allcourses_button = By.xpath("//a[contains(text(),'ALL COURSES')]");

    public Iframe(WebDriver driver) {
        this.driver = driver;
        controlHelpers = new ControlHelpers(driver);
    }

    public void ByVisibleElement(String visibleelement) {
        try {
            driver.switchTo().frame("courses-iframe");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[contains(text(),'ALL COURSES')]")));
            driver.findElement(allcourses_button).click();
            int i = 0;
            do {
                js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@id='page']/descendant::div/h4[contains(text(),'" + visibleelement + "')]")));
                i++;
                //   System.out.println(driver.findElement(By.xpath("//div[@id='page']/descendant::div/h4[contains(text(),'" + visibleelement + "')]")).isDisplayed());
            }
            while (i < 1);
            js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@id='page']/descendant::div/h4[contains(text(),'" + visibleelement + "')]")));
            //   driver.findElement(By.xpath("//div[@id='page']/descendant::div/h4[contains(text(),'" + visibleelement + "')]")).isDisplayed() == false
            driver.findElement(By.xpath("//div[@id='page']/descendant::div/h4[contains(text(),'" + visibleelement + "')]")).click();

            //  js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//div[@id='page']/descendant::div/h4[contains(text(),'" + visibleelement + "')]")));
        } catch (Exception e) {
            throw new RuntimeException("VisibleElement is not visible " + e.getMessage());
        }
    }

    public void select_course(String couresename) {
        try {
            WebElement element = driver.findElement(By.xpath("//div[@id='page']/descendant::div/h4[contains(text(),'" + couresename + "')]"));
            element.click();
        } catch (Exception e) {
            throw new RuntimeException("cause not selected " + e.getMessage());
        }

    }

}

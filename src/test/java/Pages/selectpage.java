package Pages;

import Helpers.ControlHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;

public class selectpage {
    ControlHelpers controlHelpers;
    public WebDriver driver;
    public By multi_select = By.xpath("//div[@id='page']/descendant::select[@id='multiple-select-example']");
    public By dropdwnn_select = By.xpath("//div[@id='page']/descendant::select[@id='carselect']");

    public selectpage(WebDriver driver) {
        this.driver = driver;
        controlHelpers = new ControlHelpers(driver);
    }

    public void selectmuliple(By element, String nametoselect) throws AWTException {
        WebElement e = driver.findElement(element);
        //*this is for dropdown functionality*//
        //   e.click();
        //***//
        Select s = new Select(e);
        Robot robot;
        if (s.isMultiple()) {
             robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            s.selectByValue(nametoselect);
            System.out.println(nametoselect);
        }
    }
}

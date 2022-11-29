package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ControlHelpers {

    protected WebDriver driver;
    public ControlHelpers(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement WaitForElement(By locator) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element;
        } catch (Exception e) {
           throw new Exception(e.getMessage());
        }

    }
    public WebElement GetWebElement(By locator) throws Exception {

        return  WaitForElement(locator);
    }

    public void ButtonClick(By locator) throws Exception {
        GetWebElement(locator).click();
    }
    public int IsElementPresent(By locator) {
        return driver.findElements(locator).size();
    }
    public void EnterText(By locator,String textToEnter) throws Exception {
        GetWebElement(locator).clear();
        GetWebElement(locator).sendKeys(textToEnter);
    }

    public String GetText(By locator) throws Exception {


        return GetWebElement(locator).getText();
    }

    public String GetText_WithoutDelay(By locator)
    {
        return driver.findElement(locator).getText();
    }

    public void SwitchToFrames_and_Click(int index,By Element_locator) throws Exception {
        driver.switchTo().frame(index);
        GetWebElement(Element_locator).click();
        driver.switchTo().defaultContent();
    }
    public void SwitchToFrames_and_Click(By frameLocator,By Element_locator) throws Exception {
        driver.switchTo().frame(driver.findElement(frameLocator));
        GetWebElement(Element_locator).click();
        driver.switchTo().defaultContent();
    }
}

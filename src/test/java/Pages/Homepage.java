package Pages;

import Helpers.ControlHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {

    ControlHelpers controlHelpers;
    public WebDriver driver;
    By alert_input_text = By.xpath("//div[@id='page']/descendant::input[@placeholder='Enter Your Name']");
    By alert_button = By.xpath(" //div[@id='page']/descendant::input[@id='alertbtn']");

    By confirm_button = By.xpath(" //div[@id='page']/descendant::input[@id='confirmbtn']");

    public Homepage(WebDriver driver) {
        this.driver = driver;
        controlHelpers = new ControlHelpers(driver);
    }

    public void input_to_alert(String enteryourname) {
        try {
            controlHelpers.EnterText(alert_input_text, enteryourname);
        } catch (Exception e) {
            throw new RuntimeException("please enter valid text" + e.getMessage());
        }
    }

    public void alert_button() {

        try {
            controlHelpers.ButtonClick(alert_button);
        } catch (Exception e) {
            throw new RuntimeException("alert button click not done " + e.getMessage());
        }
    }

    public void confirm_button() {
        try {
            controlHelpers.ButtonClick(confirm_button);
        } catch (Exception e) {
            throw new RuntimeException("confirm button click not done " + e.getMessage());
        }
    }


    public String actualAlertMessage() {
        String actu_msg = driver.switchTo().alert().getText();
        return actu_msg;
    }

    public void Acceptalert() {
        driver.switchTo().alert().accept();
    }
}

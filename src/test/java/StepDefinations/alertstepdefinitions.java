package StepDefinations;

import Helpers.PicoContainer;
import Pages.Homepage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class alertstepdefinitions {
    String ref1;
    private WebDriver driver;
    Homepage homepage;

    public alertstepdefinitions(PicoContainer picoContainer) {
        driver = picoContainer.driver;
        homepage = new Homepage(driver);
    }

    @Given("^i am on the letskodeit page$")
    public void i_am_on_the_letskodeit_page(){

    }

    @When("^user enters Name \"([^\"]*)\"$")
    public void user_enters_name_something(String strArg1) {
        ref1 = strArg1;
        homepage.input_to_alert(strArg1);
    }

    @When("^user click on confirm button$")
    public void user_click_on_confirm_button() {
        homepage.confirm_button();
    }

    @When("user click on Alert button")
    public void user_click_on_alert_button() {
        homepage.alert_button();
    }

    @Then("^user name will be displayed on top of page$")
    public void user_name_will_be_displayed_on_top_of_page() {
        String actual = homepage.actualAlertMessage();
        String find = ref1;
        int i = actual.indexOf(find);
        if (i > 0) {
            driver.switchTo().alert().accept();
            System.out.println("Keyword matched the string");
            Assert.assertTrue(true);
        } else {
            driver.switchTo().alert().dismiss();
            Assert.assertTrue(false, "Keyword not matched the string");
        }
        homepage.Acceptalert();
    }
}

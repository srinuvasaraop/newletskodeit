package StepDefinations;

import Helpers.PicoContainer;
import Pages.Iframe;
import Pages.selectpage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class iframestepdefinitions {
    private WebDriver driver;
    public Iframe iframe;

    public iframestepdefinitions(PicoContainer picoContainer) {
        driver = picoContainer.driver;
        iframe = new Iframe(driver);
    }

    @When("When user sends {string}")
    public void whenUserSends(String coursename) {
        iframe.ByVisibleElement(coursename);
       // iframe.select_course(coursename);
    }

    @Then("validate the particular  {string} is selected")
    public void validate_the_particular_is_selected(String selectedcourdse) {
//        WebElement element = driver.findElement(By.xpath("//div[@id='page']/descendant::div/h4[contains(text(),'" + selectedcourdse + "')]"));
//        String actualdata = element.getText();
//        Assert.assertEquals(actualdata, selectedcourdse);
    }
}

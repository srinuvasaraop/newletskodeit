package StepDefinations;

import Helpers.PicoContainer;
import Pages.selectpage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class dropdownstepdefinitions {
    private WebDriver driver;
    public selectpage sel;

    public dropdownstepdefinitions(PicoContainer picoContainer) {
        driver = picoContainer.driver;
        sel = new selectpage(driver);
    }

    @Then("validate particular item is selected")
    public void validate_particular_item_is_selected() {
        Select s = new Select(driver.findElement(sel.dropdwnn_select));
        WebElement  ele=s.getFirstSelectedOption();
        String value=ele.getText();

        boolean bl=driver.findElement(sel.dropdwnn_select).isSelected();
        Assert.assertTrue(bl);
//        if (str.contains("active")) {
//            System.out.println("WebElement selected");
//            Assert.assertTrue(true);
//        } else {
//            System.out.println("WebElement NOT selected");
//            Assert.assertTrue(true);
//        }

    }
}

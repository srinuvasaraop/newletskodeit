package StepDefinations;

import Helpers.PicoContainer;
import Pages.selectpage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;


import java.awt.*;
import java.util.List;

public class selectstepdefinitions {
    private WebDriver driver;
    public selectpage sel;

    public selectstepdefinitions(PicoContainer picoContainer) {
        driver = picoContainer.driver;
        sel = new selectpage(driver);
    }

    @Given("user on homepage")
    public void user_on_homepage() {

    }

    @When("^user sends fruit name name$")
    public void user_sends_fruit_name_name(DataTable dataTable) throws AWTException {
        List ls = dataTable.asLists();
        for (int i = 0; i <= ls.size() - 1; i++) {
            String str = ls.get(i).toString();
            System.out.println(str);
            String st = str.replaceAll("\\[", "").replaceAll("\\]", "");
            System.out.println(st);
            sel.selectmuliple(sel.multi_select, st);
        }

//        String str=ls.get(0).toString();
//        System.out.println(str);
//        String st=str.replaceAll("\\[", "").replaceAll("\\]","");
//       // sel.selectmuliple(sel.multi_select,st);
//        sel.selectmuliple(sel.dropdwnn_select,st);
    }

    @When("user send {string}")
    public void user_send(String string) throws AWTException {
        sel.selectmuliple(sel.multi_select, string);
    }

    @Then("sended fruit name will be selected")
    public void sended_fruit_name_will_be_selected() {

        System.out.println("getting output happyly");
    }
}

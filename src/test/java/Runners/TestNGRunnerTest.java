package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        ,features = "src/test/java/FeatureFiles"
        ,tags= "@19989"
        ,glue = {"StepDefinations","Hooks"}
        ,monochrome = true)
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {


}

package com.bdd.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/withoutLogin.feature",
        glue = "com/bdd/cucumber/steps",
        plugin = {
                "pretty",                              // For readable console output
                "html:target/cucumber-reports.html",   // HTML report
                "json:target/cucumber.json"
        }
)
public class TestRunner {
}
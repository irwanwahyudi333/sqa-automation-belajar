package com.antigravity.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features", glue = "com.antigravity.steps", plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
})
public class TestRunner extends AbstractTestNGCucumberTests {

    // Kode ajaib ini memberi tahu TestNG untuk menjalankan skenario secara
    // bersamaan (paralel)
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
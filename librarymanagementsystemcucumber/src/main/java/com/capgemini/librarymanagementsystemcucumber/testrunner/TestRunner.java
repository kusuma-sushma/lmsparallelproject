package com.capgemini.librarymanagementsystemcucumber.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/com/capgemini/librarymanagementsystemcucumber/feature", glue = {
		"com/capgemini/librarymanagementsystemcucumber/steps" }, dryRun = false, tags = {
				"~@ignore" }, plugin = { "pretty", "html:target/cucumber" }, monochrome = true)
public class TestRunner {

}

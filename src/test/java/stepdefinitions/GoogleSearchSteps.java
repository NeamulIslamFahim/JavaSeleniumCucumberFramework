package stepdefinitions;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;
import org.apache.commons.io.FileUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import BaseTest.BaseTest;

public class GoogleSearchSteps {

    private WebDriver driver;

    public GoogleSearchSteps() {
        if (BaseTest.driver == null) {
            new BaseTest().setup(); // Ensure driver is initialized if not already
        }
        this.driver = BaseTest.driver;
    }

    @Given("I am on the Google homepage")
    public void i_am_on_the_google_homepage() {
        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void i_search_for(String searchText) {
        driver.findElement(By.name("q")).sendKeys(searchText);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("I should see {string} in the search results")
    public void i_should_see_in_the_search_results(String expectedText) {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("target/screenshots/google_search_results.png"));
            String pageSource = driver.getPageSource();
            System.out.println("Page Source: " + pageSource);
            Assert.assertTrue(pageSource != null && pageSource.contains(expectedText));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to take screenshot or read page source: " + e.getMessage());
        }
    }
}

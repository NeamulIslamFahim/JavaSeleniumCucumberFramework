import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class GoogleSearchSteps {

    private WebDriver driver;

    public GoogleSearchSteps() {
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
        Assert.assertTrue(driver.getPageSource().contains(expectedText));
    }
}

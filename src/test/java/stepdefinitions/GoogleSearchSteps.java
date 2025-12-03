import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchSteps {

    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am on the Google homepage")
    public void i_am_on_the_google_homepage() {
        WebDriver driver = getDriver();
        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void i_search_for(String searchText) {
        WebDriver driver = getDriver();
        driver.findElement(By.name("q")).sendKeys(searchText);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("I should see {string} in the search results")
    public void i_should_see_in_the_search_results(String expectedText) {
        WebDriver driver = getDriver();
        Assert.assertTrue(driver.getPageSource().contains(expectedText));
    }
}

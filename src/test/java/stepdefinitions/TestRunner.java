import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty",
              "json:target/cucumber-reports/CucumberTestReport.json",
              "rerun:target/cucumber-reports/rerun.txt"},
    monochrome = true,
    publish = true
)
public class TestRunner {

}

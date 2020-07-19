import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;
import io.cucumber.testng.TestNGCucumberRunner.*;


@CucumberOptions(
        features = {"src/test/features"},
        glue = {"stepdefs"},
        strict = true,
        plugin = {"pretty", "html:target/cucumber"}
)
@Test
public class RunCucumberTests extends AbstractTestNGCucumberTests {
}